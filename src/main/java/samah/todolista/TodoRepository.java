package samah.todolista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for Todo entities
@Repository // Angiver, at dette er et repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Ingen yderligere metoder kræves, da JpaRepository allerede har de nødvendige CRUD-operationer
}
