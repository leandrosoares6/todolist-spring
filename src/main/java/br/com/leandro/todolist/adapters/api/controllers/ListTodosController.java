package br.com.leandro.todolist.adapters.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Page<TodoResponse> index(
			@PageableDefault(page = 0, size = 10, sort = "title", direction = Direction.ASC) Pageable pagination) {
		ListTodos listTodos = new ListTodos(todoRepository, viewModel);
		return (Page<TodoResponse>) listTodos.execute(pagination);
	}

}
