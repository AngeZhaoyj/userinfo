package com.zyj.domain;

import java.util.Date;

public class Userinfo {

	private int userinfo_id;
	private String coded;
	private String name;
	private String name_spell;
	private int dept_id; 
	private String telephone;
	private String email;
	private Integer state; 
	private Date gmt_create;
	
	private Page page;
	
	public int getUserinfo_id() {
		return userinfo_id;
	}
	public void setUserinfo_id(int userinfo_id) {
		this.userinfo_id = userinfo_id;
	}
	public String getCoded() {
		return coded;
	}
	public void setCoded(String coded) {
		this.coded = coded;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_spell() {
		return name_spell;
	}
	public void setName_spell(String name_spell) {
		this.name_spell = name_spell;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
