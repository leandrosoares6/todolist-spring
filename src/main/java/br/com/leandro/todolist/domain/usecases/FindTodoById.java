package br.com.leandro.todolist.domain.usecases;

import java.util.Optional;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class FindTodoById {

	private TodoRepository todoRepository;

	public FindTodoById(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo execute(String id) {
		Optional<Todo> todoFromDd = todoRepository.findById(id);

		if (!todoFromDd.isPresent()) {
			throw new EntityNotFoundException("Entity not found.");
		}

		return todoFromDd.get();
	}

}
