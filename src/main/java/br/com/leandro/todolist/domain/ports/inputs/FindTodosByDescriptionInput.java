package br.com.leandro.todolist.domain.ports.inputs;

import org.springframework.data.domain.Page;

public interface FindTodosByDescriptionInput {

	Page<?> execute(String description);

}
