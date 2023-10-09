package org.example.services;

import org.example.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    Integer addNewRestaurant(Restaurant restaurant);
    void updateRating(Restaurant newRating);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getAllRestaurantsByCity(String city);

    Restaurant getRestaurantById(Integer id);

    void deleteRestaurantById(Integer id);

    List<Restaurant> sortRestaurantsByRating();
}
