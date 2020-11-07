package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dao.RestaurantRepository;
import com.restaurant.exceptions.RestaurantNotFoundException;
import com.restaurant.model.Restaurant;
@Service
public class RestaurantServiceImpl implements RestaurantService {

	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		
		Restaurant newRestaurant = restaurantRepository.save(restaurant);
		return newRestaurant;
		
	}

	@Override
	public Restaurant getRestaurantById(int id) throws RestaurantNotFoundException {
		
		return restaurantRepository.findById(id)
				.orElseThrow(()-> new RestaurantNotFoundException("Restaurant with given Id not available") );
	}

	@Override
	public boolean deleteRestaurant(int id) throws RestaurantNotFoundException {
		
		restaurantRepository.deleteById(id);
		return true;
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		return restaurantRepository.findAll();
		
	}

	@Override
	public List<Restaurant> getRestaurantByCity(String city) throws RestaurantNotFoundException {
		
		List<Restaurant> restaurantList = restaurantRepository.findByCity(city);
		if(restaurantList.isEmpty()) {
			throw new RestaurantNotFoundException("Restaurant with given city not available");
		}
		return restaurantList;
		
	}

	@Override
	public List<Restaurant> getRestaurantsByCuisine(String cuisine) throws RestaurantNotFoundException {
		
		List<Restaurant> restaurantList = restaurantRepository.findByCuisine(cuisine);
		if(restaurantList.isEmpty()) {
			throw new RestaurantNotFoundException("Restaurant with given cuisine not available");
		}
		return restaurantList;
		
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant) {
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getRestaurantByRating(float rating) throws RestaurantNotFoundException {
		List<Restaurant> restaurantList = restaurantRepository.findByRating(rating);
		if(restaurantList.isEmpty()) {
			throw new RestaurantNotFoundException("Restaurant with given rating not available");
		}
		return restaurantList;
	}

}
