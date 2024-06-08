package ehealthcare.Bean;

import java.time.LocalTime;
import java.util.Date;

public class AppointmentBean extends BaseBean{

	private String doctorName;
	private String patientname;
	private String disease;
	private Date appointmentdate;
	private LocalTime appointmenttime;
	private String appointmentdescription;
	private String doctor;
	private long userid;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Date getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(Date appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public LocalTime getAppointmenttime() {
		return appointmenttime;
	}
	public void setAppointmenttime(LocalTime appointmenttime) {
		this.appointmenttime = appointmenttime;
	}
	public String getAppointmentdescription() {
		return appointmentdescription;
	}
	public void setAppointmentdescription(String appointmentdescription) {
		this.appointmentdescription = appointmentdescription;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
}
