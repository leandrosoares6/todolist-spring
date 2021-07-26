package br.com.leandro.todolist.adapters.api.viewmodels;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.entities.Todo;
import br.com.leandro.todolist.domain.ports.outputs.IListTodosOutput;

@Component
public class ListTodosViewModel implements IListTodosOutput {

	@Override
	@SuppressWarnings("unchecked")
	public Page<TodoResponse> presentTodos(Page<Todo> todos) {
		return new PageImpl<TodoResponse>(
				(List<TodoResponse>) todos.getContent().stream().map(todo -> new TodoResponse(todo)), todos.getPageable(),
				todos.getTotalElements());
	}

}
