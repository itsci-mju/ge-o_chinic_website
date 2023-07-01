package org.itsci.models;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "appoinmentweekday")
public class AppoinmentWeekDay {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appoinment_week_day;
	@Column(length = 25)
	private Date appoinment_time_strat;
	@Column(length = 25)
	private Date appoinment_time_end;
	
	@OneToMany(mappedBy="appoinmentweekday")
	private List<Appoinment> list_appoinment = new Vector<>();
	
	@ManyToOne
	@JoinColumn(name = "Room_FK",nullable = false)
	private Room room;
	
	@ManyToOne
	@JoinColumn(name = "Doctor_FK",nullable = false)
	private Doctor doctor;
	
	public AppoinmentWeekDay() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public AppoinmentWeekDay(Date appoinment_time_strat, Date appoinment_time_end,
			List<Appoinment> list_appoinment, Room room, Doctor doctor) {
		super();
		this.appoinment_time_strat = appoinment_time_strat;
		this.appoinment_time_end = appoinment_time_end;
		this.list_appoinment = list_appoinment;
		this.room = room;
		this.doctor = doctor;
	}



	public int getAppoinment_week_day() {
		return appoinment_week_day;
	}

	public void setAppoinment_week_day(int appoinment_week_day) {
		this.appoinment_week_day = appoinment_week_day;
	}

	public Date getAppoinment_time_strat() {
		return appoinment_time_strat;
	}

	public void setAppoinment_time_strat(Date appoinment_time_strat) {
		this.appoinment_time_strat = appoinment_time_strat;
	}

	public Date getAppoinment_time_end() {
		return appoinment_time_end;
	}

	public void setAppoinment_time_end(Date appoinment_time_end) {
		this.appoinment_time_end = appoinment_time_end;
	}

	public List<Appoinment> getList_appoinment() {
		return list_appoinment;
	}

	public void setList_appoinment(List<Appoinment> list_appoinment) {
		this.list_appoinment = list_appoinment;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	
	
}
