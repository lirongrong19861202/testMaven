package com.chillax.dto;

public class HouseInfo {
	
	private int  id;//自增id
    private int  community;//小区
    private int  house_num;//房号
    public int getHouse_num() {
		return house_num;
	}
	public void setHouse_num(int house_num) {
		this.house_num = house_num;
	}
	private int building;//栋号
	private String floor_num;//层号
    public String getFloor_num() {
		return floor_num;
	}
	public void setFloor_num(String floor_num) {
		this.floor_num = floor_num;
	}
	private String num;//房号
    private float house_area;//房屋面积
    private float calculate_area;//建筑面积
    private int  apartment_type;//户型 
    private String  structure;//建筑结构
    private String lease_nuture;//租赁性质 1：公租房
    private int  community_status;//房屋状态 1：在建 2：建成待租 3：已配租 4：已租赁 5：腾退待租 6：欠费 7：其他
	private String locate;//
	private String position;
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommunity() {
		return community;
	}
	public void setCommunity(int community) {
		this.community = community;
	}
	public int getBuilding() {
		return building;
	}
	public void setBuilding(int building) {
		this.building = building;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public float getHouse_area() {
		return house_area;
	}
	public void setHouse_area(float house_area) {
		this.house_area = house_area;
	}
	public float getCalculate_area() {
		return calculate_area;
	}
	public void setCalculate_area(float calculate_area) {
		this.calculate_area = calculate_area;
	}
	public int getApartment_type() {
		return apartment_type;
	}
	public void setApartment_type(int apartment_type) {
		this.apartment_type = apartment_type;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getLease_nuture() {
		return lease_nuture;
	}
	public void setLease_nuture(String lease_nuture) {
		this.lease_nuture = lease_nuture;
	}
	public int getCommunity_status() {
		return community_status;
	}
	public void setCommunity_status(int community_status) {
		this.community_status = community_status;
	}
}
