package org.itsci.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expertise")
public class Expertise {
	@Id
	private int expertise_id;
	@Column(length = 45)
	private String expertise_name;
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
 
}
