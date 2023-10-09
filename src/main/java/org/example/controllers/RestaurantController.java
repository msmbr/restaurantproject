package org.example.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.RatingData;
import org.example.entity.Restaurant;
import org.example.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {


    private final RestaurantService restaurantService;


    @PostMapping
    public Integer addNewProduct(@RequestBody Restaurant restaurant){
        log.info("create new restaurant");
        return restaurantService.addNewRestaurant(restaurant);
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurants(){
        log.info("getAllRestaurants");
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/sort")
    public List<Restaurant> getAllRestaurantsOrdered(){
        log.info("getAllRestaurants");
        return restaurantService.sortRestaurantsByRating();
    }

    @GetMapping("/query")
    public Restaurant getRestaurantById(@RequestParam Integer id){
        log.info("getRestaurantById");
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/query/city")
    public List<Restaurant> getRestaurantByCity(@RequestParam String city){
        log.info("getRestaurantByCity");
        return restaurantService.getAllRestaurantsByCity(city);
    }

    @PutMapping("/{id}")
    public String updateOrder(@PathVariable Integer id, @RequestBody RatingData ratingData){
        log.info("updateOrder");

        Restaurant restaurant = restaurantService.getRestaurantById(id);
        restaurant.setRating(ratingData.getRating());
        restaurant.setVotes(ratingData.getVotes());
        restaurantService.updateRating(restaurant);
        return "ok";
    }
    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Integer id){
        log.info("deleteOrderById");
        restaurantService.deleteRestaurantById(id);
    }

     /*
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        log.info("Run method get order by id");
        return service.getOrderById(id);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        log.info("Run method get all orders");
        return service.getAllOrders();
    }

    @GetMapping("/user")
    public List<Order> getAllOrders(@RequestParam String username){
        log.info("Run method get all orders by user name");
        return service.getOrdersByUsername(username);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        log.info("Run method update order");
        return service.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id){
        log.info("Run method delete order by id");
        service.deleteOrderById(id);
    }*/

}
