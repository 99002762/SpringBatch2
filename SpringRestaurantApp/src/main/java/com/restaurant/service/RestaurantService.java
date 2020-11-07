package com.restaurant.service;

import java.util.List;

import com.restaurant.exceptions.RestaurantNotFoundException;
import com.restaurant.model.Restaurant;

public interface RestaurantService {
	
	
	Restaurant addRestaurant(Restaurant restaurant);
	Restaurant getRestaurantById(int id) throws  RestaurantNotFoundException;
	boolean deleteRestaurant(int id) throws  RestaurantNotFoundException;
	List<Restaurant> getAllRestaurants();
	 
	List<Restaurant> getRestaurantByCity(String city) throws  RestaurantNotFoundException;
	List<Restaurant> getRestaurantsByCuisine(String cuisine) throws RestaurantNotFoundException;
	Restaurant updateRestaurant(Restaurant restaurant);
	List<Restaurant> getRestaurantByRating(float rating) throws  RestaurantNotFoundException;

}
