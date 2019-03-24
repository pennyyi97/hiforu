package hiroad.bus;

public class BusVO {

	private String course;
	private String station;
	private String depart_time;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getDepart_time() {
		return depart_time;
	}
	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}
	
	@Override
	public String toString() {
		return "BusVO [course=" + course + ", station=" + station + ", depart_time=" + depart_time + "]";
	}
	
	
}
