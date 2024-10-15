package samah.todolista;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Användarens unika ID

    private String username;  // Användarnamn för användaren
    private String email;  // E-postadress för användaren
    private String password;  // Lösenord för användaren
    private String role;  // Användarens roll, t.ex. "ROLE_USER" eller "ROLE_ADMIN"

    // Standardkonstruktor
    public User() {
    }

    // Konstruktor som tar alla fält som parametrar
    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter och setter för id
    public Long getId() {
        return id;  // Hämtar användarens ID
    }

    public void setId(Long id) {
        this.id = id;  // Sätter användarens ID
    }

    // Getter och setter för användarnamn
    public String getUsername() {
        return username;  // Hämtar användarnamnet
    }

    public void setUsername(String username) {
        this.username = username;  // Sätter användarnamnet
    }

    // Getter och setter för e-post
    public String getEmail() {
        return email;  // Hämtar e-postadressen
    }

    public void setEmail(String email) {
        this.email = email;  // Sätter e-postadressen
    }

    // Getter och setter för lösenord
    public String getPassword() {
        return password;  // Hämtar lösenordet
    }

    public void setPassword(String password) {
        this.password = password;  // Sätter lösenordet
    }

    // Getter och setter för roll
    public String getRole() {
        return role;  // Hämtar användarens roll
    }

    public void setRole(String role) {
        this.role = role;  // Sätter användarens roll
    }
}
