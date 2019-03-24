/*
 * MessageNameFormat.java
 * Copyright(C) 2012 Tomatosystem Corporation. LTD. All Rights Reserved.
 * This file is part of Tomatosystem Common Platform.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageNameFormat {
	private static final String PATTERN = "[{][a-zA-Z0-9_]*[}]";
	private Part[] parts;
	private String msg;
	private List paramNames;

	public MessageNameFormat(String msg) {
		if(msg == null) throw new NullPointerException("message is null");
		this.msg = msg;
		this.paramNames = new ArrayList();
		parse();
	}

	private void parse() {
		List partsList = new ArrayList();
		
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(msg);
		if(matcher == null) {
			partsList.add(new TextPart(msg));
			return;
		}
		
		String group;
		int before = 0, start, end;
		ParamPart param;
		while(matcher.find()) {
			group = matcher.group();
			start = matcher.start();
			end = matcher.end();
			
			if(before < start) {
				partsList.add(new TextPart(this.msg.substring(before, start)));
			}
			param = new ParamPart(group);
			partsList.add(param);
			if(this.paramNames.contains(param.paramName) == false) {
				this.paramNames.add(param.paramName);
			}

			before = end;
		}
		
		if(before <= this.msg.length() - 1) {
			partsList.add(new TextPart(this.msg.substring(before)));
		}

		this.parts = (Part[]) partsList.toArray(new Part[0]);
	}
	
	public String[] getParameterNames() {
		return (String[])this.paramNames.toArray(new String[0]);
	}
	
	public String format(Map param) {
		StringBuffer msg = new StringBuffer();
		
		for(int i = 0; i < this.parts.length; i++) {
			msg.append(this.parts[i].parse(param));
		}
		
		return msg.toString();
	}
	
	public String format(String[] param) {
		if(param == null || param.length == 0) return this.msg;
		StringBuffer msg = new StringBuffer();
		
		int pos = 0;
		for(int i = 0; i < this.parts.length; i++) {
			if(pos < param.length) {
				msg.append(this.parts[i].parse(param[pos]));
			} else {
				msg.append(this.parts[i].parse((String)null));
			}
			if(this.parts[i] instanceof ParamPart) {
				pos++;
			}
		}
		
		return msg.toString();
	}
	
	private interface Part {
		String parse(Map params);
		String parse(String param);
	}
	
	private class TextPart implements Part {
		private String part;
		public TextPart(String part) {
			this.part = part;
		}

		public String parse(Map params) {
			return this.part;
		}
		
		public String parse(String param) {
			return this.part;
		}
	}
	
	private class ParamPart implements Part {
		private String paramName;
		public ParamPart(String paramName) {
			this.paramName = paramName.substring(1, paramName.length() - 1);
		}

		public String parse(Map params) {
			if(params == null || params.size() == 0) return "";
			else {
				Object value = params.get(this.paramName);
				if(value == null) return "";
				else return value.toString();
			}
		}
		
		public String parse(String param) {
			return param == null ? this.paramName : param;
		}
	}
	
	public static void main(String[] args) {
		MessageNameFormat format = new MessageNameFormat("안녕하세요.\n {name} 입니다. \n계좌번호는 {account_num}.");
		
		java.util.HashMap param = new java.util.HashMap();
		param.put("name", "최은진");
		param.put("account_num", "123-1234-12-1222");
		
		System.out.println(format.format(param));
	}



}

