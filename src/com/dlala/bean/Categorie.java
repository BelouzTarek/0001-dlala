package com.dlala.bean;

public class Categorie {

	public String value;
	public String name;
	public String disable;
	public String style;
	
	
	public Categorie(String value, String name, String disable, String style) {
		super();
		this.value = value;
		this.name = name;
		this.disable = disable;
		this.style = style;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisable() {
		return disable;
	}
	public void setDisable(String disable) {
		this.disable = disable;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	

}
