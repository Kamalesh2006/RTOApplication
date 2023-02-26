package com.rtoapplication.dto;

public class Vehicle {
	private String vehicleNumber;
	private String registrationAt;  //contains the city at which the vehicle got registered
	private String registrationDate;
	private String ownerName;
	private String vehicleType;
	private String modalName;
	public Vehicle() {
		super();
	}
	public Vehicle( String vehicleNumber,String registrationAt, String registrationDate, String ownerName,
			String vehicleType, String modalName) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.registrationAt = registrationAt;
		this.registrationDate = registrationDate;
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
		this.modalName = modalName;
	}
	public String getRegistrationAt() {
		return registrationAt;
	}
	public void setRegistrationAt(String registrationAt) {
		this.registrationAt = registrationAt;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getModalName() {
		return modalName;
	}
	public void setModalName(String modalName) {
		this.modalName = modalName;
	}
	
}
