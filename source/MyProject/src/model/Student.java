package model;

public class Student {
	private String idstudent;
	private String studentname;
	private String tell;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String idstudent, String studentname, String tell) {
		super();
		this.idstudent = idstudent;
		this.studentname = studentname;
		this.tell = tell;
	}
	public String getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(String idstudent) {
		this.idstudent = idstudent;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}


 
	
	
}
