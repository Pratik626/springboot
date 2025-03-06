package com.wipro.springboot.usecase1; // Defines the package for this application

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.*; 
import jakarta.persistence.*; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List; 
import java.util.Optional; 


@SpringBootApplication // Marks this as a Spring Boot application
@RestController // Indicates that this class will handle REST API requests
@RequestMapping 
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args); 
    }

    @Autowired // Injects the TodoService dependency
    private TodoService todoService; // Service layer object to handle business logic

    //  to fetch all to-do items
    @GetMapping // Maps HTTP GET requests to this method
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos(); // Calls service method to get all tasks
    }

    //  to fetch a specific to-do item by ID
    @GetMapping("/{id}") // Maps HTTP GET request with ID parameter
    public Optional<Todo> getTodoById(@PathVariable Long id) { // Extracts ID from URL
        return todoService.getTodoById(id); // Calls service method to get task by ID
    }

    //to create a new to-do item
    @PostMapping // Maps HTTP POST requests to this method
    public Todo createTodo(@RequestBody Todo todo) { // Extracts request body as a Todo object
        return todoService.createTodo(todo); // Calls service method to save the new task
    }

    // to update an existing to-do item
    @PutMapping("/{id}") // Maps HTTP PUT requests with an ID parameter
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) { // Extracts ID from URL and request body as Todo object
        return todoService.updateTodo(id, todo); // Calls service method to update the task
    }

    //  to delete a to-do item
    @DeleteMapping("/{id}") // Maps HTTP DELETE requests with an ID parameter
    public void deleteTodoById(@PathVariable Long id) { // Extracts ID from URL
        todoService.deleteTodoById(id); // Calls service method to delete task by ID
    }
}

// Entity class representing a to-do task
@Entity // Marks this class as a JPA entity
@Table(name = "TodoApplication") // Specifies the database table name
class Todo {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates ID values incrementally
    private Long id; // Unique identifier for each to-do task

    @Column(nullable = false) // Ensures the column cannot be null
    private String task; // Stores the task description

    @Column(nullable = false) // Ensures the column cannot be null
    private boolean completed; // Indicates whether the task is completed or not

    // Default constructor (required by JPA)
    public Todo() {}

    // Parameterized constructor to initialize task and status
    public Todo(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    // Getter and setter methods for id
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getter and setter methods for task description
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    // Getter and setter methods for task completion status
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}

// Repository interface for database operations
@Repository // Marks this as a repository component
interface TodoRepository extends JpaRepository<Todo, Long> { // Extends JpaRepository to provide CRUD operations
    // JpaRepository provides built-in methods, so no need to write extra queries
}

// Service layer handling business logic
@Service // Marks this as a service component
class TodoService {

    @Autowired // Injects the TodoRepository dependency
    private TodoRepository todoRepository;

    // Retrieves all to-do tasks from the database
    public List<Todo> getAllTodos() {
        return todoRepository.findAll(); // Calls repository method to fetch all records
    }

    // Retrieves a single to-do task by ID
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id); // Calls repository method to find by ID
    }

    // Creates a new to-do task and saves it to the database
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo); // Calls repository method to save the task
    }

    // Updates an existing to-do task
    public Todo updateTodo(Long id, Todo updatedTodo) {
        if (todoRepository.existsById(id)) { // Checks if task exists
            updatedTodo.setId(id); // Sets the existing ID to the updated object
            return todoRepository.save(updatedTodo); // Saves updated task
        }
        return null; // Returns null if task does not exist
    }

    // Deletes a to-do task by ID
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id); // Calls repository method to delete by ID
    }
}
