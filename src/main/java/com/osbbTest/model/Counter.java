package com.osbbTest.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "counters")
public class Counter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	@Embedded
	private ServiceType serviceType;
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;	

	public Counter(){}
	
	public Counter( ServiceType serviceType, double amount) {			
		this.serviceType = serviceType;
		this.amount = amount;
	}
	
	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Counter: { ").append(getServiceType()).append(" ").append(getAmount()).append(" }");					
		return sb.toString();
		}
	
}
