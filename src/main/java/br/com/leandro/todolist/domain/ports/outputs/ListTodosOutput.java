package br.com.leandro.todolist.domain.ports.outputs;

import org.springframework.data.domain.Page;

import br.com.leandro.todolist.domain.entities.Todo;

public interface ListTodosOutput {

	Page<?> presentTodos(Page<Todo> todos);

}