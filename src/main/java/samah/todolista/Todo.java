package samah.todolista;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todos") // Mappas till "todos" tabellen i databasen
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genererar ett unikt ID för varje nytt inlägg
    private Long id;

    @Column(name = "title") // Mappas till kolumnen "description" i databasen

    private String title;

    @Column(name = "description") // Mappas till kolumnen "description" i databasen
    private String description;

    @Column(name = "completed") // Mappas till kolonnen "completed" i databasen
    private boolean completed;
}
