package org.itsci.models;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "appoinment")
public class Appoinment {
	@Id
	private int appoinment_id;
	@Column(length = 25)
	private Date appoinment_time;
	@Column(length = 45)
	private String medicoName;
	@Column(length = 5)
	private int status;
	@Column(length = 45)
	private Date time_strat;
	@Column(length = 45)
	private Date time_end;
	@Column(length = 45)
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "appoinmentweekday_FK")
	private AppoinmentWeekDay appoinmentweekday;
	
	@ManyToOne
	@JoinColumn(name = "service_FK",nullable = false)
	private Service service;
	
	@OneToMany(mappedBy="appoinment")
	private List<BuyService> list_buyservice = new Vector<>();
	
	public Appoinment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appoinment(int appoinment_id, Date appoinment_time, String medicoName, int status, Date time_strat,
			Date time_end, String note, Service service) {
		super();
		this.appoinment_id = appoinment_id;
		this.appoinment_time = appoinment_time;
		this.medicoName = medicoName;
		this.status = status;
		this.time_strat = time_strat;
		this.time_end = time_end;
		this.note = note;
		this.service = service;
	}

	public int getAppoinment_id() {
		return appoinment_id;
	}
	public void setAppoinment_id(int appoinment_id) {
		this.appoinment_id = appoinment_id;
	}
	public Date getAppoinment_time() {
		return appoinment_time;
	}
	public void setAppoinment_time(Date appoinment_time) {
		this.appoinment_time = appoinment_time;
	}
	public String getMedicoName() {
		return medicoName;
	}
	public void setMedicoName(String medicoName) {
		this.medicoName = medicoName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getTime_strat() {
		return time_strat;
	}
	public void setTime_strat(Date time_strat) {
		this.time_strat = time_strat;
	}
	public Date getTime_end() {
		return time_end;
	}
	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public AppoinmentWeekDay getAppoinmentweekday() {
		return appoinmentweekday;
	}
	public void setAppoinmentweekday(AppoinmentWeekDay appoinmentweekday) {
		this.appoinmentweekday = appoinmentweekday;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public List<BuyService> getList_buyservice() {
		return list_buyservice;
	}
	public void setList_buyservice(List<BuyService> list_buyservice) {
		this.list_buyservice = list_buyservice;
	}
}
