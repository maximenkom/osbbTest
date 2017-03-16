package com.osbbTest.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class ServiceType {
	  
 private String serviceName;
 
 private double rate;
 
 public ServiceType(){}

 public ServiceType(String serviceName, double rate) {	
		this.serviceName = serviceName;
		this.rate = rate;
}
 
public double getRate() {
	return rate;
}

public void setRate(double rate) {
	this.rate = rate;
}

public String getServiceName() {
	return serviceName;
}

public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}
@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(" { service: ").append(getServiceName()).append(" rate ").append(getRate()).append(" }");				
	return sb.toString();
	}
}
