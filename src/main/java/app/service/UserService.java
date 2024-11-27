package app.service;

import app.entity.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Отримати всіх користувачів
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Отримати користувача за id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Створити нового користувача
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Оновити користувача
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setIsAdmin(userDetails.getIsAdmin());

        return userRepository.save(user);
    }

    // Видалити користувача
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    // Знайти користувача за email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
