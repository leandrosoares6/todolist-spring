package br.com.leandro.todolist.domain.usecases;

import java.util.Optional;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class RemoveTodo {

	private TodoRepository todoRepository;

	public RemoveTodo(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public void execute(String id) {
		Optional<Todo> todoFromDd = todoRepository.findById(id);

		if (!todoFromDd.isPresent()) {
			throw new EntityNotFoundException("Entity not found.");
		}

		todoRepository.destroy(todoFromDd.get());
	}

}
