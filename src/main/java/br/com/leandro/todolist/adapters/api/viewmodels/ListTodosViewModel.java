package br.com.leandro.todolist.adapters.api.viewmodels;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.outputs.ListTodosOutput;

@Component
public class ListTodosViewModel implements ListTodosOutput {

	@Override
	public Page<TodoResponse> presentTodos(Page<Todo> todos) {
		List<TodoResponse> todoResponseList = todos.getContent().stream().map(todo -> new TodoResponse(todo))
				.collect(Collectors.toList());

		return new PageImpl<TodoResponse>(todoResponseList, todos.getPageable(), todos.getTotalElements());
	}

}
