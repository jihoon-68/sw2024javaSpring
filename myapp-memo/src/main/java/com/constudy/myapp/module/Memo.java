package com.constudy.myapp.module;

public class Memo {
	private int id;
	private String title;
	private String detail;
	
	public Memo() {
		this(0,"","");
	}
	public Memo( String title, String detail) {
		this(0,title,detail);
	}
	
	public Memo(int id, String title, String detail) {
		this.id =id;
		this.title =title;
		this.detail = detail;
	}
	
	
	public int getId() { 
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getDetail() {
		return this.detail;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	@Override
	public String toString() {
		return "memo[id: "+id+",title: "+title+",detail:"+detail+"]";	
	}
}
