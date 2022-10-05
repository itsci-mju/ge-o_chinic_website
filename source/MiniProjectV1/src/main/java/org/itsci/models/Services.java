package org.itsci.models;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int service_id;
	@Column(length = 50,nullable = false)
	private String serviceName;
	@Column(length = 255,nullable = false)
	private String serviceDetail;
	@Column(length = 5,nullable = false)
	private int serviceStatus;
	@Column(length = 45,nullable = false)
	private double price;
	@Column(length = 50,nullable = false)
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "servicetype_FK",nullable = false)
	private ServiceType servicetype;
	
	@OneToMany(mappedBy="service")
	private List<Appoinment> list_appoinment = new Vector<>();
	
	@OneToMany(mappedBy="service")
	private List<BuyService> list_buyservice = new Vector<>();
	
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Services(String serviceName, String serviceDetail, int serviceStatus, double price,
			String image, ServiceType servicetype) {
		super();

		this.serviceName = serviceName;
		this.serviceDetail = serviceDetail;
		this.serviceStatus = serviceStatus;
		this.price = price;
		this.image = image;
		this.servicetype = servicetype;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDetail() {
		return serviceDetail;
	}

	public void setServiceDetail(String serviceDetail) {
		this.serviceDetail = serviceDetail;
	}

	public int getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ServiceType getServicetype() {
		return servicetype;
	}

	public void setServicetype(ServiceType servicetype) {
		this.servicetype = servicetype;
	}

	public List<Appoinment> getList_appoinment() {
		return list_appoinment;
	}

	public void setList_appoinment(List<Appoinment> list_appoinment) {
		this.list_appoinment = list_appoinment;
	}

	public List<BuyService> getList_buyservice() {
		return list_buyservice;
	}

	public void setList_buyservice(List<BuyService> list_buyservice) {
		this.list_buyservice = list_buyservice;
	}
	
	public Services(int service_id, String serviceName, String serviceDetail, int serviceStatus, double price,
			String image, ServiceType servicetype) {
		super();
		this.service_id = service_id;
		this.serviceName = serviceName;
		this.serviceDetail = serviceDetail;
		this.serviceStatus = serviceStatus;
		this.price = price;
		this.image = image;
		this.servicetype = servicetype;
	}
	
	
}
