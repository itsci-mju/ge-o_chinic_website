package org.itsci.goclinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receipt")
public class Receipt {
	@Id
	private int receipt_id;
	
	@ManyToOne
	@JoinColumn(name = "buyservice_FK",nullable = false)
	private BuyService buyservice;

	public Receipt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Receipt(int receipt_id, BuyService buyservice) {
		super();
		this.receipt_id = receipt_id;
		this.buyservice = buyservice;
	}
	public int getReceipt_id() {
		return receipt_id;
	}
	public void setReceipt_id(int receipt_id) {
		this.receipt_id = receipt_id;
	}
	public BuyService getBuyservice() {
		return buyservice;
	}
	public void setBuyservice(BuyService buyservice) {
		this.buyservice = buyservice;
	}
	
}
