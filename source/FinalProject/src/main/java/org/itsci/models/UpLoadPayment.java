package org.itsci.models;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "uploadpayment")
public class UpLoadPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uploadPayment_id;
	@Column(length = 45)
	private String images;
	
	@OneToMany(mappedBy="uploadpayment")
	private List<BuyService> list_buyservice = new Vector<>();
	
	public UpLoadPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpLoadPayment( String images) {
		super();
		this.images = images;
	}
	
	 public void updateImage(String images) {
	        this.images = images;
	 }
	 
	public int getUploadPayment_id() {
		return uploadPayment_id;
	}
	public void setUploadPayment_id(int uploadPayment_id) {
		this.uploadPayment_id = uploadPayment_id;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public List<BuyService> getList_buyservice() {
		return list_buyservice;
	}
	public void setList_buyservice(List<BuyService> list_buyservice) {
		this.list_buyservice = list_buyservice;
	}
	
	
}
