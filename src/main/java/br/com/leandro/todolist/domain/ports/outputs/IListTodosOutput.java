package br.com.leandro.todolist.domain.ports.outputs;

import java.util.List;

import br.com.leandro.todolist.domain.entities.Todo;

public interface IListTodosOutput {

	List<?> presentTodos(List<Todo> todos);

}