package br.com.leandro.todolist.domain.ports.inputs;

import java.util.Optional;

public interface FindTodoByIdInput {

	Optional<?> execute(String id);

}
