package samah.todolista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepositoryjava userRepository;

    @Autowired
    public UserService(UserRepositoryjava userRepository) {
        this.userRepository = userRepository;
    }

    // Hent bruger efter brugernavn
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Hent alle brugere
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Opret en ny bruger
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Opdater bruger
    public Optional<User> updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    // Slet bruger
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
