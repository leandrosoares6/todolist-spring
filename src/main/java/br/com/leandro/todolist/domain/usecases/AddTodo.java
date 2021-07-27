package br.com.leandro.todolist.domain.usecases;

import br.com.leandro.todolist.domain.dtos.TodoData;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.exceptions.EntityAlreadyExistsException;
import br.com.leandro.todolist.domain.ports.TodoRepository;
import br.com.leandro.todolist.domain.ports.inputs.AddTodoInput;
import br.com.leandro.todolist.domain.ports.outputs.AddTodoOutput;

public class AddTodo implements AddTodoInput {

	private final TodoRepository todoRepository;

	private final AddTodoOutput presenter;

	public AddTodo(TodoRepository todoRepository, AddTodoOutput presenter) {
		this.todoRepository = todoRepository;
		this.presenter = presenter;
	}

	@Override
	public Object execute(TodoData todoData) {
		Todo todoFromDd = todoRepository.findByTitle(todoData.getTitle());

		if (todoFromDd != null) {
			throw new EntityAlreadyExistsException("Entity already exists.");
		}

		Todo todo = new Todo(todoData.getTitle(), todoData.getDescription());

		todoRepository.save(todo);

		return presenter.presentTodo(todo);
	}

}
