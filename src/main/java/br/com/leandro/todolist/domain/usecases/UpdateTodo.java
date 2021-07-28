package br.com.leandro.todolist.domain.usecases;

import java.time.LocalDateTime;
import java.util.Optional;

import br.com.leandro.todolist.domain.dtos.TodoData;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.enums.Status;
import br.com.leandro.todolist.domain.exceptions.EntityNotFoundException;
import br.com.leandro.todolist.domain.ports.TodoRepository;

public class UpdateTodo {

	private final TodoRepository todoRepository;

	public UpdateTodo(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public Todo execute(String id, TodoData todoData) {
		Optional<Todo> todoFromDd = todoRepository.findById(id);

		if (!todoFromDd.isPresent()) {
			throw new EntityNotFoundException("Todo not found.");
		}

		Todo todo = todoFromDd.get();
		todo.setTitle(todoData.getTitle());
		todo.setDescription(todoData.getDescription());
		todo.setStatus(todoData.getStatus());

		if (todo.getStatus() == Status.COMPLETED) {
			todo.setCompletedAt(LocalDateTime.now());
		}

		todoRepository.save(todo);

		return todoFromDd.get();
	}

}
