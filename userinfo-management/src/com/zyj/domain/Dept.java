package com.zyj.domain;

public class Dept {

	private int dept_id;
	private String coded;
	private String name;
	
	private Page page;
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
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
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
