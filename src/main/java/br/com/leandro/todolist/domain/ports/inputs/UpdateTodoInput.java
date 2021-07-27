package br.com.leandro.todolist.domain.ports.inputs;

import br.com.leandro.todolist.domain.dtos.TodoData;

public interface UpdateTodoInput {

	Class<?> execute(TodoData todo);

}
