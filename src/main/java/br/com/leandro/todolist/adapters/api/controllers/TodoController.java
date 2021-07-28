package br.com.leandro.todolist.adapters.api.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.leandro.todolist.adapters.api.requests.TodoRequest;
import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.TodoRepository;
import br.com.leandro.todolist.domain.usecases.AddTodo;
import br.com.leandro.todolist.domain.usecases.FindTodoById;
import br.com.leandro.todolist.domain.usecases.ListTodos;
import br.com.leandro.todolist.domain.usecases.RemoveTodo;
import br.com.leandro.todolist.domain.usecases.UpdateTodo;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoRepository todoRepository;

	@PostMapping
	public ResponseEntity<TodoResponse> create(@Valid @RequestBody TodoRequest todoRequest) {
		AddTodo addTodo = new AddTodo(todoRepository);
		Todo response = addTodo.execute(todoRequest.convert());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	public Page<TodoResponse> index(
			@PageableDefault(page = 0, size = 10, sort = "title", direction = Direction.ASC) Pageable pagination) {
		ListTodos listTodos = new ListTodos(todoRepository);
		return TodoResponse.fromTodoPage(listTodos.execute(pagination));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TodoResponse> show(@PathVariable String id) {
		FindTodoById findTodo = new FindTodoById(todoRepository);
		return ResponseEntity.ok(new TodoResponse(findTodo.execute(id)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TodoResponse> update(@PathVariable String id, @Valid @RequestBody TodoRequest todoRequest) {
		UpdateTodo updateTodo = new UpdateTodo(todoRepository);
		return ResponseEntity.ok(new TodoResponse(updateTodo.execute(id, todoRequest.convert())));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TodoResponse> destroy(@PathVariable String id) {
		RemoveTodo deleteTodo = new RemoveTodo(todoRepository);
		deleteTodo.execute(id);
		return ResponseEntity.noContent().build();
	}

}
