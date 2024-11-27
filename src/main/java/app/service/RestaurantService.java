package app.service;

import app.entity.Restaurant;
import app.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Restaurant restaurant = getRestaurantById(id);
        restaurant.setName(updatedRestaurant.getName());
        restaurant.setAddress(updatedRestaurant.getAddress());
        restaurant.setTypeWork(updatedRestaurant.getTypeWork());
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
