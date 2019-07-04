package com.chillax.dto;

//栋数
public class BuildNo {
	
	private int  id;
    private String  no;//栋数
    private int house_num;//楼号
    public int getHouse_num() {
		return house_num;
	}
	public void setHouse_num(int house_num) {
		this.house_num = house_num;
	}
	private int community_id;//小区
   
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
