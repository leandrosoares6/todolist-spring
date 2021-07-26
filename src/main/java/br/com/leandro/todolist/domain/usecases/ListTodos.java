package br.com.leandro.todolist.domain.usecases;

import java.util.List;
import java.util.Optional;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.ITodoRepository;
import br.com.leandro.todolist.domain.ports.inputs.IListTodosInput;
import br.com.leandro.todolist.domain.ports.outputs.IListTodosOutput;

public class ListTodos implements IListTodosInput {

	private ITodoRepository todoRepository;

	private IListTodosOutput presenter;

	public ListTodos(ITodoRepository todoRepository, IListTodosOutput presenter) {
		this.todoRepository = todoRepository;
		this.presenter = presenter;
	}

	public List<?> execute(Optional<Integer> page, Optional<Integer> size) {
		int validPage = page.isPresent() && page.get() >= 0 ? page.get() : 0;
		int validSize = size.isPresent() && size.get() <= 50 && size.get() > 0 ? size.get() : 10;
		List<Todo> todos = todoRepository.findAll(validPage, validSize);
		return presenter.presentTodos(todos);
	}

}
