package com.huuthuong.spring;

public class Offer {
    private int id;
    private String name;
    private String mail;
    private String text;
    
    public Offer() {}
    
	public Offer(String name, String mail, String text) {
		this.name = name;
		this.mail = mail;
		this.text = text;
	}
	
	public Offer(int id, String name, String mail, String text) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", mail=" + mail
				+ ", text=" + text + "]";
	}
    
    
}
