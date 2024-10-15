package samah.todolista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Hent alle todo-opgaver
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Hent todo-opgave efter ID
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    // Opret en ny todo-opgave
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Opdater en eksisterende todo-opgave
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> existingTodoOpt = todoRepository.findById(id);

        if (existingTodoOpt.isPresent()) {
            Todo existingTodo = existingTodoOpt.get();
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existingTodo);
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
    }


    // Ta bort en todo-uppgift
    public boolean deleteTodo(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Todo not found with id: " + id);
        }
    }
}
