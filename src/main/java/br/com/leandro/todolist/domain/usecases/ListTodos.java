package br.com.leandro.todolist.domain.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.ITodoRepository;
import br.com.leandro.todolist.domain.ports.inputs.IListTodosInput;
import br.com.leandro.todolist.domain.ports.outputs.IListTodosOutput;

public class ListTodos implements IListTodosInput {

	private final ITodoRepository todoRepository;

	private final IListTodosOutput presenter;

	public ListTodos(ITodoRepository todoRepository, IListTodosOutput presenter) {
		this.todoRepository = todoRepository;
		this.presenter = presenter;
	}

	public Page<?> execute(Pageable pagination) {
		Page<Todo> todos = todoRepository.findAll(pagination);
		return presenter.presentTodos(todos);
	}

}
