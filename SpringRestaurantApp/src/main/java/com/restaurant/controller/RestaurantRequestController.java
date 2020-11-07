package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.exceptions.RestaurantNotFoundException;
import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant-api")

public class RestaurantRequestController {
	@Autowired
	RestaurantService restaurantService;
	
	 @PostMapping("/restaurants")
	    ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		 Restaurant nrestaurant = restaurantService.addRestaurant(restaurant);
	        return ResponseEntity.ok(nrestaurant);
	    }
	    @DeleteMapping("/restaurants/delete/{id}")
	    ResponseEntity<Boolean> deleteRestaurant(@PathVariable("id")Integer id) throws RestaurantNotFoundException{
	    	boolean flag=restaurantService.deleteRestaurant(id);
	    	 HttpHeaders header = new HttpHeaders();
		        header.add("desc", "Deleting Restaurant by Id");
		        header.add("title", "One Restaurant");
		        return ResponseEntity.status(HttpStatus.OK)
		                .headers(header).body(flag);
	        //return ResponseEntity.status(HttpStatus.OK).build();
	    }
	    @GetMapping("/restaurants/get-one/{id}")
	    ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id")Integer id) throws RestaurantNotFoundException{
	    	Restaurant nrestaurant = restaurantService.getRestaurantById(id);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", "Getting Restaurant by Id");
	        header.add("title", "One Restaurant");
	        return ResponseEntity.status(HttpStatus.OK)
	                .headers(header).body(nrestaurant);
	    }
	    
	    @GetMapping("/restaurants")
	    ResponseEntity<List<Restaurant>> getAllRestaurants(){
	        List<Restaurant> restaurantList =  restaurantService.getAllRestaurants();
	        return ResponseEntity.ok(restaurantList);
	    }
	    @GetMapping("/restaurants/city/{city}")
	    ResponseEntity<List<Restaurant>> getRestaurantByCity(@PathVariable("city")String city) throws RestaurantNotFoundException{
	        List<Restaurant> restaurantList =   restaurantService.getRestaurantByCity(city);
	        return ResponseEntity.ok(restaurantList);
	    }
	    @GetMapping("/restaurants/cuisine/{cuisine}")
	    ResponseEntity<List<Restaurant>> getRestaurantByCuisine(@PathVariable("cuisine")String cuisine)throws RestaurantNotFoundException{
	        List<Restaurant> restaurantList = restaurantService.getRestaurantsByCuisine(cuisine);    
	        return ResponseEntity.ok(restaurantList);
	    }
	    
	    @GetMapping("/restaurants/rating/{rating}")
	    ResponseEntity<List<Restaurant>> getRestaurantByRating(@PathVariable("rating")float rating)throws RestaurantNotFoundException{
	        List<Restaurant> restaurantList = restaurantService.getRestaurantByRating(rating);    
	        return ResponseEntity.ok(restaurantList);
	    }
	    
	    
	    @PutMapping("/restaurants/update")
		ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant) {
			
	    	Restaurant nrestaurant = restaurantService.updateRestaurant(restaurant);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", "Updating Restaurant");
	        header.add("title", "One Restaurant");
	        return ResponseEntity.status(HttpStatus.OK)
	                .headers(header).body(nrestaurant);
			
		}

}
