package org.itsci.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "logins")
public class Logins {
	@Id
	private String email;
	@Column(length = 16,nullable = false)
	private String password;
	@Column(length = 2,nullable = false)
	private String type;
	
	@OneToOne(mappedBy="logins")
	private Person persons;
	
	public Logins() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logins(String email, String password, String type) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Logins(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Person getPersons() {
		return persons;
	}

	public void setPersons(Person persons) {
		this.persons = persons;
	}
	
	
	
}
