package org.itsci.goclinic.model;

import java.util.List;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "servicetype")
public class ServiceType {
	@Id
	private int servicetype_id;
	@Column(length = 45,nullable = false)
	private String service_type;
	
	@OneToMany(mappedBy="servicetype")
	private List<Services> list_service = new Vector<>();

	
	public ServiceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceType(int servicetype_id, String service_type) {
		super();
		this.servicetype_id = servicetype_id;
		this.service_type = service_type;
	}

	public int getServicetype_id() {
		return servicetype_id;
	}

	public void setServicetype_id(int servicetype_id) {
		this.servicetype_id = servicetype_id;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public List<Services> getList_service() {
		return list_service;
	}

	public void setList_service(List<Services> list_service) {
		this.list_service = list_service;
	}	
}
