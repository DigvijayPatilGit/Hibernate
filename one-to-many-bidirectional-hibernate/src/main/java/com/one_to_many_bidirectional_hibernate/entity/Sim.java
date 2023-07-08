package com.one_to_many_bidirectional_hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String provider;
	private String imrcNo;
	private long simNo;
	@ManyToOne
	@JoinColumn
	private Mobile mobile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getImrcNo() {
		return imrcNo;
	}
	public void setImrcNo(String imrcNo) {
		this.imrcNo = imrcNo;
	}
	public long getSimNo() {
		return simNo;
	}
	public void setSimNo(long simNo) {
		this.simNo = simNo;
	}
	public Mobile getMobile() {
		return mobile;
	}
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Sim [id=" + id + ", provider=" + provider + ", imrcNo=" + imrcNo + ", simNo=" + simNo + "]";
		//Remove the another class referance Mobile=+mobile+ for repetation of data and we get exception
	}

}
