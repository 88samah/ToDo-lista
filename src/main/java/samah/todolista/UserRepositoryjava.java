package samah.todolista;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepositoryjava extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
