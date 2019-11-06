package com.project.springboot.myapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.myapp.entity.Restaurant;
import com.project.springboot.myapp.service.RestaurantService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	private RestaurantService restaurantService;

	@Autowired
	public AdminController(RestaurantService theRestaurantService) {
		restaurantService = theRestaurantService;
	}

	@GetMapping(value = "/restaurant/list")
	public List<Restaurant> getAllRestaurants() {
		return restaurantService.findAll();
	}

	@GetMapping(value = "/restaurant/{restaurantId}")
	private Restaurant getRestaurantById(@PathVariable Integer restaurantId) {
		return restaurantService.findById(restaurantId);

	}

	@PostMapping(value = "/addRestaurant")
	public void setRestaurant(@RequestBody Restaurant theStudent) {
		restaurantService.save(theStudent);
	}

	@GetMapping(value = "/deleteRestaurant/{restaurantId}")
	private void deleteRestaurant(@PathVariable Integer restaurantId) {
		restaurantService.deleteById(restaurantId);
	}

}
