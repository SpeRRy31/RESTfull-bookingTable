package app.service;

import app.dto.RestaurantDTO;
import app.entity.Restaurant;
import app.mapper.RestaurantMapper;
import app.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    // Отримати всі ресторани
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::toDTO) // Перетворення з Entity у DTO
                .collect(Collectors.toList());
    }

    // Отримати ресторан за ID
    public RestaurantDTO getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ресторан не знайдено"));
        return restaurantMapper.toDTO(restaurant);
    }

    // Створити ресторан
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantMapper.toEntity(restaurantDTO); // Перетворення з DTO у Entity
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.toDTO(savedRestaurant);
    }

    // Оновити ресторан
    public RestaurantDTO updateRestaurant(Long id, RestaurantDTO restaurantDTO) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ресторан не знайдено"));

        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setTypeWork(restaurantDTO.getTypeWork());

        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return restaurantMapper.toDTO(updatedRestaurant);
    }

    // Видалити ресторан
    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new RuntimeException("Ресторан не знайдено");
        }
        restaurantRepository.deleteById(id);
    }
}
