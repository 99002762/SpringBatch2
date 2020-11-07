package com.restaurant.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Restaurant;
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,Integer> {
	
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByCuisine(String cuisine);
	//Restaurant findById(Integer id);
	List<Restaurant> findByRating(float rating);
	
	

}
