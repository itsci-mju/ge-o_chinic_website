package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "logins")
public class Logins {
//	@Id
//	@Column(name = "name",length = 15)
	private String name;
//	@Column(name = "pass",length = 15)
	private String pass;
//	@Column(name = "fullname",length = 15)
	private String fullname;
//	@Column(name = "gender",length = 15)
	private String gender;
//	@Column(name = "image",length = 15)
	private String image; 
	
	public Logins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Logins(String name, String pass, String fullname, String gender, String image) {
		super();
		this.name = name;
		this.pass = pass;
		this.fullname = fullname;
		this.gender = gender;
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
