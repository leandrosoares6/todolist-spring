package br.com.leandro.todolist.domain.usecases;

import br.com.leandro.todolist.domain.dtos.TodoData;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class AddTodo {

	private final TodoRepository todoRepository;

	public AddTodo(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo execute(TodoData todoData) {
		Todo todo = new Todo(todoData.getTitle(), todoData.getDescription());

		if (todoData.getStatus() != null) {
			todo.setStatus(todoData.getStatus());
		}

		todoRepository.save(todo);

		return todo;
	}

}
