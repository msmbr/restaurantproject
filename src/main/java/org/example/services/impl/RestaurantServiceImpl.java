package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Restaurant;
import org.example.repository.RestaurantRepository;
import org.example.services.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public Integer addNewRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant).getId();
    }

    @Override
    public void updateRating(Restaurant newRestaurantData) {
        restaurantRepository.save(newRestaurantData);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getAllRestaurantsByCity(String city) {
        return restaurantRepository.findAllByCity(city);
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public void deleteRestaurantById(Integer id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<Restaurant> sortRestaurantsByRating() {
        return restaurantRepository.findAllByOrderByRatingDesc();
    }
}
