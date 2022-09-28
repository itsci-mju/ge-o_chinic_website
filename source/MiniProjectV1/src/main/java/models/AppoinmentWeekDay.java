package models;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "appoinmentweekday")
public class AppoinmentWeekDay {
	@Id
	private int appoinment_week_day;
	@Column(length = 25)
	private Date appoinment_time_strat;
	@Column(length = 25)
	private Date appoinment_time_end;
	
	@OneToMany(mappedBy="appoinmentweekday")
	private List<Appoinment> list_appoinment = new Vector<>();
	
	public AppoinmentWeekDay() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AppoinmentWeekDay(int appoinment_week_day, Date appoinment_time_strat, Date appoinment_time_end) {
		super();
		this.appoinment_week_day = appoinment_week_day;
		this.appoinment_time_strat = appoinment_time_strat;
		this.appoinment_time_end = appoinment_time_end;
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


	
	
}
