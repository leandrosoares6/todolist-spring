package br.com.leandro.todolist.domain.ports.outputs;

import br.com.leandro.todolist.domain.entities.Todo;

public interface AddTodoOutput {

	Object presentTodo(Todo todo);

}
