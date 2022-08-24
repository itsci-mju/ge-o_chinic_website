package model;

public class Register {
	private int idre;
	private String name;
	private String pass;
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(int idre, String name, String pass) {
		super();
		this.idre = idre;
		this.name = name;
		this.pass = pass;
	}
	public int getIdre() {
		return idre;
	}
	public void setIdre(int idre) {
		this.idre = idre;
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
	
	
}
