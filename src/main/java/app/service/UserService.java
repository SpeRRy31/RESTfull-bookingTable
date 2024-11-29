package app.service;

import app.dto.UserDTO;
import app.entity.User;
import app.mapper.UserMapper;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Отримати всіх користувачів
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO) // Перетворення з Entity у DTO
                .collect(Collectors.toList());
    }

    // Отримати користувача за ID
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Користувача не знайдено"));
        return userMapper.toDTO(user);
    }

    // Створити користувача
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO); // Перетворення з DTO у Entity
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    // Оновити користувача
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Користувача не знайдено"));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setIsAdmin(userDTO.getIsAdmin());

        User updatedUser = userRepository.save(user);
        return userMapper.toDTO(updatedUser);
    }

    // Видалити користувача
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Користувача не знайдено");
        }
        userRepository.deleteById(id);
    }
}
