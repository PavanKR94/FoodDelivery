package com.project.springboot.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboot.myapp.entity.Menu;
import com.project.springboot.myapp.entity.Restaurant;
import com.project.springboot.myapp.responseEntities.CheckOutResponse;
import com.project.springboot.myapp.service.RestaurantService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static CheckOutResponse checkOutResp;
	private static List<CheckOutResponse> orderList = new ArrayList<CheckOutResponse>();

	private RestaurantService restaurantService;

	@Autowired
	public UserController(RestaurantService theRestaurantService) {
		restaurantService = theRestaurantService;
	}

	@GetMapping(value = "/restaurant/list")
	public List<Restaurant> getAllStudents() {
		return restaurantService.findAll();
	}

	@PostMapping(value = "/restaurant/{restaurantId}")
	public Restaurant getTheRestaurant(@PathVariable Integer restaurantId) {
		return restaurantService.findById(restaurantId);

	}

	@PostMapping(value = "/restaurant/getMenu/{restaurantId}")
	public String getTheMenu(@PathVariable Integer restaurantId) {
		Restaurant theStudent = restaurantService.findById(restaurantId);
		return theStudent.getRestaurantMenu();
	}

	@PostMapping(value = "/restaurant/getMenu/{restaurantId}/{dishName}")
	public ResponseEntity<CheckOutResponse> getOneDish(@PathVariable Integer restaurantId,
			@PathVariable String dishName) throws JsonMappingException, JsonProcessingException {
		Restaurant theStudent = restaurantService.findById(restaurantId);
		ObjectMapper menu = new ObjectMapper();
		Menu menuPrice = menu.readValue(theStudent.getRestaurantMenu(), Menu.class);
		Map<String, String> menuPriceData = menuPrice.getNamePrice();

		CheckOutResponse checkOut = new CheckOutResponse(theStudent.getRestaurantName(), dishName,
				menuPriceData.get(dishName));
		return new ResponseEntity<CheckOutResponse>(checkOut, HttpStatus.OK);
	}

	@PostMapping(value = "/restaurant/getMenu/confirmOrder")
	public String checkOut(@RequestBody CheckOutResponse checkOutResponse)
			throws JsonMappingException, JsonProcessingException {
		List<Restaurant> allStudents = restaurantService.findAll();
		String actualPrice = "";
		// Check the response
		if (checkOutResponse.getConfirmOrder()) {
			for (Restaurant student : allStudents) {
				if (student.getRestaurantName().equals(checkOutResponse.getRestauantName())) {
					ObjectMapper menu = new ObjectMapper();
					Menu menuPrice = menu.readValue(student.getRestaurantMenu(), Menu.class);
					Map<String, String> menuPriceData = menuPrice.getNamePrice();
					actualPrice = menuPriceData.get(checkOutResponse.getDishSelected());

				}
			}
			checkOutResponse.setTotalPrice(actualPrice);
			checkOutResp = checkOutResponse;
			orderList.add(checkOutResp);
			return "redirect:/yourOrders";
		} else {
			return "redirect:/restaurant/list";
		}
	}

	@GetMapping(value = "/yourOrders")
	public List<CheckOutResponse> getOrderList() {
		if (!orderList.isEmpty())
			return orderList;
		else
			throw new RuntimeException();
	}

}
