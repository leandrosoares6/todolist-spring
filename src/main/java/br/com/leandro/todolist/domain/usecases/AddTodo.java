package br.com.leandro.todolist.domain.usecases;

import br.com.leandro.todolist.adapters.api.requests.TodoRequest;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityAlreadyExistsException;
import br.com.leandro.todolist.domain.ports.ITodoRepository;

public class AddTodo {

	private ITodoRepository todoRepository;

	public AddTodo(ITodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public String execute(TodoRequest todoRequest) {
		Todo todoFromDd = todoRepository.findByTitle(todoRequest.getTitle());

		if (todoFromDd != null) {
			throw new EntityAlreadyExistsException("Entity already exists.");
		}

		Todo todo = new Todo(todoRequest.getTitle(), todoRequest.getDescription());

		todoRepository.save(todo);

		return todo.getId();
	}

}
