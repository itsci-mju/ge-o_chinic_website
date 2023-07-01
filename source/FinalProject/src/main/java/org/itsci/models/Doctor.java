package org.itsci.models;

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
@Table(name = "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctor_id;
	@Column(length = 45)
	private String doctor_name;
	
	@ManyToOne
	@JoinColumn(name = "expertise_FK",nullable = false)
	private Expertise expertise;
	
	@OneToMany(mappedBy="doctor")
	private List<AppoinmentWeekDay> appoinmentweekday = new Vector<>();
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(String doctor_name, Expertise expertise) {
		super();
		this.doctor_name = doctor_name;
		this.expertise = expertise;
	}

	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public Expertise getExpertise() {
		return expertise;
	}
	public void setExpertise(Expertise expertise) {
		this.expertise = expertise;
	}
	
	
}
