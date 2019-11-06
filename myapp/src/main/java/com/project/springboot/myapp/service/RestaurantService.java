package com.project.springboot.myapp.service;

import java.util.List;

import com.project.springboot.myapp.entity.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> findAll();
	
	public Restaurant findById(Integer theId);
	
	public void save(Restaurant theStudent);
	
	public void deleteById(Integer theId);

}
