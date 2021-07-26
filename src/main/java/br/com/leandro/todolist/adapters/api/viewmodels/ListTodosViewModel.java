package br.com.leandro.todolist.adapters.api.viewmodels;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.outputs.IListTodosOutput;

@Component
public class ListTodosViewModel implements IListTodosOutput {

	@Override
	public List<TodoResponse> presentTodos(List<Todo> todos) {
		Stream<TodoResponse> todosResponse = todos.stream().map(todo -> new TodoResponse(todo));
		return todosResponse.collect(Collectors.toList());
	}

}
