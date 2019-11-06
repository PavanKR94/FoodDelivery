package com.project.springboot.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.springboot.myapp.dao.RestaurantRepository;
import com.project.springboot.myapp.entity.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepository;

	public RestaurantServiceImpl(RestaurantRepository theRestaurantRepository) {
		restaurantRepository = theRestaurantRepository;
	}

	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant findById(Integer theId) {
		Optional<Restaurant> theStudent = restaurantRepository.findById(theId);
		if (theStudent.isPresent())
			return theStudent.get();
		else
			throw new RuntimeException();
	}

	@Override
	public void save(Restaurant theStudent) {
		restaurantRepository.save(theStudent);
	}

	@Override
	public void deleteById(Integer theId) {
		Optional<Restaurant> theStudent = restaurantRepository.findById(theId);
		if (theStudent.isPresent())
			restaurantRepository.deleteById(theId);
		else
			throw new RuntimeException();
	}

}
