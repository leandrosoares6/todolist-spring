package br.com.leandro.todolist.adapters.api.responses;

import br.com.leandro.todolist.domain.entities.Todo;

public class TodoResponse {

	private final String id;

	private final String title;

	private final String description;

	public TodoResponse(Todo todo) {
		this.id = todo.getId();
		this.title = todo.getTitle();
		this.description = todo.getDescription();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}
