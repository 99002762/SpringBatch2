package com.restaurant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurant")
@TypeAlias("Restaurant")
public class Restaurant {
	@Id
	Integer id;
	String name;
	String city;
	String cuisine;
	float rating;
	
	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(Integer id, String name, String city, String cuisine, float rating) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.cuisine = cuisine;
		this.rating = rating;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", city=" + city + ", cuisine=" + cuisine + ", rating="
				+ rating + "]";
	}
	
	
	
	

}
