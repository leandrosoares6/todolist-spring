package br.com.leandro.todolist.adapters.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.ports.ITodoRepository;
import br.com.leandro.todolist.domain.ports.outputs.IListTodosOutput;
import br.com.leandro.todolist.domain.usecases.ListTodos;

@RestController
@RequestMapping("/todos")
public class ListTodosController {

	@Autowired
	private ITodoRepository todoRepository;

	@Autowired
	private IListTodosOutput viewModel;

	@GetMapping
	@SuppressWarnings("unchecked")
	public List<TodoResponse> index(@RequestParam(name = "page") Optional<Integer> page,
			@RequestParam(name = "size") Optional<Integer> size) {
		ListTodos listTodos = new ListTodos(todoRepository, viewModel);
		return (List<TodoResponse>) listTodos.execute(page, size);
	}

}
