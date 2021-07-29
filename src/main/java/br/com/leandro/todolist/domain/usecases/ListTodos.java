package br.com.leandro.todolist.domain.usecases;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class ListTodos {

	private final TodoRepository todoRepository;

	public ListTodos(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Page<Todo> execute(Pageable pagination, Map<String, String> filters) {
		Page<Todo> todos = todoRepository.findAll(pagination, filters);
		return todos;
	}

}
