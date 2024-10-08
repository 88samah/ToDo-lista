package samah.todolista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    // Injektion af TodoRepository
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Hent alle Todo's
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();  // Brug todoRepository til at hente alle todos fra databasen
    }

    // Hent Todo efter ID
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);  // Brug todoRepository til at finde todo med ID
    }

    // Opret en ny Todo
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);  // Gem todo i databasen via todoRepository
    }

    // Opdater en eksisterende Todo
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> existingTodo = todoRepository.findById(id);  // Find Todo efter id
        if (existingTodo.isPresent()) {
            Todo todo = existingTodo.get();
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(todo);  // Gem opdaterede Todo
        } else {
            return null;  // Hvis Todo ikke findes, returnér null
        }
    }


    // Slet en Todo efter ID
    public boolean deleteTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.deleteById(id);  // Slet todo fra databasen
            return true;
        } else {
            return false;  // Returnér false hvis todo ikke findes
        }
    }
}
