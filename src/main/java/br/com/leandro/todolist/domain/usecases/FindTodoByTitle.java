package br.com.leandro.todolist.domain.usecases;

import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.ITodoRepository;

public class FindTodoByTitle {

	private ITodoRepository todoRepository;

	public FindTodoByTitle(ITodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo execute(String title) {
		Todo todoFromDd = todoRepository.findByTitle(title);

		if (todoFromDd == null) {
			throw new EntityNotFoundException("Entity not found.");
		}

		return todoFromDd;
	}

}
