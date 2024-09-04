package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Todolist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("Tidur");
        todoListRepository.add(todolist);
    }

    @Test
    void testRemove() {
        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(5));
    }

    @Test
    void testGetAll() {
        todoListRepository.add(new Todolist("Makan"));
        todoListRepository.add(new Todolist("Tidur"));
        todoListRepository.add(new Todolist("Main"));
        todoListRepository.add(new Todolist("Belajar"));

        Todolist[] todolists = todoListRepository.getAll();

        for (var todo : todolists) {
            System.out.println(todo.getId() + ": " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
