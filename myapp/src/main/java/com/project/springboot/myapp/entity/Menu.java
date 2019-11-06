package com.project.springboot.myapp.entity;

import java.util.Map;

public class Menu {
	public Map<String, String> namePrice;

	public Menu(Map<String, String> namePrice) {
		super();
		this.namePrice = namePrice;
	}

	public Menu() {
		super();
	}

	@Override
	public String toString() {
		return "Menu [namePrice=" + namePrice + "]";
	}

	public Map<String, String> getNamePrice() {
		return namePrice;
	}

	public void setNamePrice(Map<String, String> namePrice) {
		this.namePrice = namePrice;
	}

}
