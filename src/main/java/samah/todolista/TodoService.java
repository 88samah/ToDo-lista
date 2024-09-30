package samah.todolista;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Genererar en konstruktor med alla 'final'-fält
public class TodoService {

    private final TodoRepository todoRepository;

    // Hämta alla Todo-element
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Hämta en Todo efter ID
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    // Skapa en ny Todo
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Uppdatera en befintlig Todo
    public Todo updateTodo(Long id, Todo updatedTodo) {
        updatedTodo.setId(id);
        return todoRepository.save(updatedTodo);
    }

    // Ta bort en Todo
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
