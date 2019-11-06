package com.project.springboot.myapp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id")
	private Integer id;

	@JoinColumn(name = "restaurant_name")
	private String restaurantName;

	@JoinColumn(name = "restaurant_location")
	private String restaurantLocation;

	@JoinColumn(name = "restaurant_menu")
	private String restaurantMenu;

	@JoinColumn(name = "restaurant_rating")
	private Double restaurantRating;

	public Restaurant() {
		super();
	}

	public Restaurant(String restaurantName, String restaurantLocation, String restaurantMenu, Double restaurantRating) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.restaurantMenu = restaurantMenu;
		this.restaurantRating = restaurantRating;
	}

	public Restaurant(Integer id, String restaurantName, String restaurantLocation, String restaurantMenu,
			Double restaurantRating) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.restaurantLocation = restaurantLocation;
		this.restaurantMenu = restaurantMenu;
		this.restaurantRating = restaurantRating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

	public String getRestaurantMenu() {
		return restaurantMenu;
	}

	public void setRestaurantMenu(String restaurantMenu) {
		this.restaurantMenu = restaurantMenu;
	}

	public Double getRestaurantRating() {
		return restaurantRating;
	}

	public void setRestaurantRating(Double restaurantRating) {
		this.restaurantRating = restaurantRating;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", restaurantName=" + restaurantName + ", restaurantLocation=" + restaurantLocation
				+ ", restaurantMenu=" + restaurantMenu + ", restaurantRating=" + restaurantRating + "]";
	}

}
