package samah.todolista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller för Todo-entiteter
@RestController // Anger att detta är en REST-controller
@RequestMapping("/todos") // Anger bas-URL för alla metoder i denna controller
public class TodoController {

    private final TodoRepository todoRepository;

    @Autowired // Injekterar TodoRepository via konstruktor
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Hämta alla Todo-element
    @GetMapping // Hanterar GET-förfrågningar till /todos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll(); // Returnerar en lista med alla Todo-element
    }

    // Hämta ett specifikt Todo-element via ID
    @GetMapping("/{id}") // Hanterar GET-förfrågningar till /todos/{id}
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todo -> new ResponseEntity<>(todo, HttpStatus.OK)) // Returnerar 200 OK med Todo
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Returnerar 404 NOT FOUND om ej hittad
    }

    // Skapa ett nytt Todo-element
    @PostMapping // Hanterar POST-förfrågningar till /todos
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoRepository.save(todo); // Sparar det nya Todo-elementet
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED); // Returnerar 201 CREATED
    }

    // Uppdatera ett befintligt Todo-element
    @PutMapping("/{id}") // Hanterar PUT-förfrågningar till /todos/{id}
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTitle(todoDetails.getTitle()); // Uppdaterar titel
                    todo.setCompleted(todoDetails.isCompleted()); // Uppdaterar status
                    Todo updatedTodo = todoRepository.save(todo); // Sparar ändringarna
                    return new ResponseEntity<>(updatedTodo, HttpStatus.OK); // Returnerar 200 OK med uppdaterad Todo
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Returnerar 404 NOT FOUND om ej hittad
    }

    // Ta bort ett Todo-element
    @DeleteMapping("/{id}") // Hanterar DELETE-förfrågningar till /todos/{id}
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todoRepository.delete(todo); // Tar bort Todo-elementet
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Returnerar 204 NO CONTENT
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Returnerar 404 NOT FOUND om ej hittad
    }
}
