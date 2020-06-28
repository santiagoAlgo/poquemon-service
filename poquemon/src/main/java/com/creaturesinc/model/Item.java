package com.creaturesinc.model;

import java.util.Map;

public class Item {
	
	String name;
	String url;
	
	public Item() {
		
	}
	
	public Item(Map<String, String> map) {
		this.name = map.get("name");
		this.url = map.get("url");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
