package models;

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
@Table(name = "buyservice")
public class BuyService {
	@Id
	private int buyservice_id;
	@Column(length = 45,nullable = false)
	private Date order_date;
	@Column(length = 5,nullable = false)
	private int status;
	@Column(length = 10,nullable = false)
	private int order_qty;
	
	@OneToMany(mappedBy="buyservice")
	private List<Receipt> list_receipt = new Vector<>();
	
	@ManyToOne
	@JoinColumn(name = "person_FK",nullable = false)
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "appoinment_FK",nullable = false)
	private Appoinment appoinment;
	
	@ManyToOne
	@JoinColumn(name = "service_FK",nullable = false)
	private Service service;
	
	@ManyToOne
	@JoinColumn(name = "uploadpayment_FK",nullable = false)
	private UpLoadPayment uploadpayment;
	
	public BuyService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BuyService(int buyservice_id, Date order_date, int status, int order_qty) {
		super();
		this.buyservice_id = buyservice_id;
		this.order_date = order_date;
		this.status = status;
		this.order_qty = order_qty;
	}

	public int getBuyservice_id() {
		return buyservice_id;
	}
	public void setBuyservice_id(int buyservice_id) {
		this.buyservice_id = buyservice_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}
	public Appoinment getAppoinment() {
		return appoinment;
	}
	public void setAppoinment(Appoinment appoinment) {
		this.appoinment = appoinment;
	}
	public List<Receipt> getList_receipt() {
		return list_receipt;
	}
	public void setList_receipt(List<Receipt> list_receipt) {
		this.list_receipt = list_receipt;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public UpLoadPayment getUploadpayment() {
		return uploadpayment;
	}
	public void setUploadpayment(UpLoadPayment uploadpayment) {
		this.uploadpayment = uploadpayment;
	}
}
