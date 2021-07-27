package br.com.leandro.todolist.domain.ports.inputs;

public interface DeleteTodoByIdInput {

	void execute(String id);

}
