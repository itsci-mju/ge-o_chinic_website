package org.itsci.models;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "expertise")
public class Expertise {
	@Id
	private int expertise_id;
	@Column(length = 45)
	private String expertise_name;
	
	@OneToMany(mappedBy="expertise")
	private List<Room> list_room = new Vector<>();
	
	@OneToMany(mappedBy="expertise")
	private List<Doctor> list_doctor = new Vector<>();
	
	@OneToMany(mappedBy="expertise")
	private List<Services> list_service = new Vector<>();
	
public Expertise() {
	super();
	// TODO Auto-generated constructor stub
}
public Expertise(int expertise_id, String expertise_name) {
	super();
	this.expertise_id = expertise_id;
	this.expertise_name = expertise_name;
}
public int getExpertise_id() {
	return expertise_id;
}
public void setExpertise_id(int expertise_id) {
	this.expertise_id = expertise_id;
}
public String getExpertise_name() {
	return expertise_name;
}
public void setExpertise_name(String expertise_name) {
	this.expertise_name = expertise_name;
}
public List<Room> getList_room() {
	return list_room;
}
public void setList_room(List<Room> list_room) {
	this.list_room = list_room;
}
public List<Services> getList_service() {
	return list_service;
}
public void setList_service(List<Services> list_service) {
	this.list_service = list_service;
}
public List<Doctor> getList_doctor() {
	return list_doctor;
}
public void setList_doctor(List<Doctor> list_doctor) {
	this.list_doctor = list_doctor;
}

}
