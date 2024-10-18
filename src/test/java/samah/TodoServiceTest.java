package samah;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import samah.todolista.ToDoListaApplication;
import samah.todolista.Todo;
import samah.todolista.TodoRepository;
import samah.todolista.TodoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ToDoListaApplication.class)
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;


    @BeforeEach
    void setUp() {
        // Opretter en Todo-objekt og gemmer det i databasen
        Todo todo = new Todo();
        todo.setTitle("Test Todo");
        todo.setDescription("Test Description");
        todo.setCompleted(false);
        todoRepository.save(todo);  // Sørg for at gemme Todo'en
    }

    @AfterEach
    void tearDown() {

        todoRepository.deleteAll();
    }

    @Test
    void testGetAllTodos() {

        List<Todo> todos = todoService.getAllTodos();
        System.out.println("Todos: " + todos);  // Debug: log liste af todos

        // Verificér at der er én Todo
        assertEquals(1, todos.size());
    }
}
