package br.com.leandro.todolist.adapters.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandro.todolist.adapters.api.requests.TodoRequest;
import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.ports.TodoRepository;
import br.com.leandro.todolist.domain.ports.outputs.AddTodoOutput;
import br.com.leandro.todolist.domain.usecases.AddTodo;

@RestController
@RequestMapping("/todos")
public class AddTodoController {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private AddTodoOutput viewModel;

	@PostMapping
	public ResponseEntity<TodoResponse> AddTodo(@RequestBody TodoRequest todoRequest) {
		AddTodo addTodo = new AddTodo(todoRepository, viewModel);
		TodoResponse response = (TodoResponse) addTodo.execute(TodoRequest.convertToTodoData(todoRequest));
		return ResponseEntity.ok(response);
	}

}