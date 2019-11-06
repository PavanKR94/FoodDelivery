package com.project.springboot.myapp.responseEntities;


public class CheckOutResponse {

	private String restauantName;
	private String dishSelected;
	private String totalPrice;
	private Boolean confirmOrder;

	public CheckOutResponse() {
		super();
	}

	public CheckOutResponse(String restauantName, String dishSelected, String totalPrice) {
		super();
		this.restauantName = restauantName;
		this.dishSelected = dishSelected;
		this.totalPrice = totalPrice;
	}

	public CheckOutResponse(String restauantName, String dishSelected, String totalPrice, Boolean confirmOrder) {
		super();
		this.restauantName = restauantName;
		this.dishSelected = dishSelected;
		this.totalPrice = totalPrice;
		this.confirmOrder = confirmOrder;
	}

	public String getRestauantName() {
		return restauantName;
	}

	public void setRestauantName(String restauantName) {
		this.restauantName = restauantName;
	}

	public String getDishSelected() {
		return dishSelected;
	}

	public void setDishSelected(String dishSelected) {
		this.dishSelected = dishSelected;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getConfirmOrder() {
		return confirmOrder;
	}

	public void setConfirmOrder(Boolean confirmOrder) {
		this.confirmOrder = confirmOrder;
	}

	@Override
	public String toString() {
		return "CheckOutResponse [restauantName=" + restauantName + ", dishSelected=" + dishSelected + ", totalPrice="
				+ totalPrice + ", confirmOrder=" + confirmOrder + "]";
	}

}
