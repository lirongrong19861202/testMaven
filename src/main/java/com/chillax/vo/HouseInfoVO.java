package com.chillax.vo;

public class HouseInfoVO {
	
	private String location;
	private String communityName;
	private String houseArea;
	private String calculateArea;
	private String apartmentType;
	private String structure;
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	private String leaseNature;
	private String status;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}
	public String getCalculateArea() {
		return calculateArea;
	}
	public void setCalculateArea(String calculateArea) {
		this.calculateArea = calculateArea;
	}
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}
	public String getLeaseNature() {
		return leaseNature;
	}
	public void setLeaseNature(String leaseNature) {
		this.leaseNature = leaseNature;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
