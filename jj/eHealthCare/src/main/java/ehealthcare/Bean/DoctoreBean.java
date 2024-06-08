package ehealthcare.Bean;

import java.time.LocalTime;

public class DoctoreBean extends BaseBean{

	private String name;
	private String email;
	private String location;
	private String gender;
	private String category;
	private LocalTime from;
	private LocalTime to;
	private String fees;
	private String experience;
	private String status;
	private long userid;
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public LocalTime getFrom() {
		return from;
	}
	public void setFrom(LocalTime from) {
		this.from = from;
	}
	public LocalTime getTo() {
		return to;
	}
	public void setTo(LocalTime to) {
		this.to = to;
	}
	
}
