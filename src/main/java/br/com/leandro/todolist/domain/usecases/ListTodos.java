package br.com.leandro.todolist.domain.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.TodoRepository;
import br.com.leandro.todolist.domain.ports.inputs.ListTodosInput;
import br.com.leandro.todolist.domain.ports.outputs.ListTodosOutput;

public class ListTodos implements ListTodosInput {

	private final TodoRepository todoRepository;

	private final ListTodosOutput presenter;

	public ListTodos(TodoRepository todoRepository, ListTodosOutput presenter) {
		this.todoRepository = todoRepository;
		this.presenter = presenter;
	}

	public Page<?> execute(Pageable pagination) {
		Page<Todo> todos = todoRepository.findAll(pagination);
		return presenter.presentTodos(todos);
	}

}
