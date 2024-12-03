package app.service;

import app.entity.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Отримання всіх користувачів
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Отримання користувача за ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Додавання нового користувача
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Оновлення користувача
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setIsAdmin(userDetails.getIsAdmin());
            return userRepository.save(user);
        }
        throw new RuntimeException("Користувач із ID " + id + " не знайдений.");
    }

    // Видалення користувача
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Користувач із ID " + id + " не знайдений.");
        }
    }
}
