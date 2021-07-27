package br.com.leandro.todolist.adapters.api.viewmodels;

import org.springframework.stereotype.Component;

import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.outputs.AddTodoOutput;

@Component
public class AddTodoViewModel implements AddTodoOutput {

	@Override
	public TodoResponse presentTodo(Todo todo) {
		return new TodoResponse(todo);
	}

}
