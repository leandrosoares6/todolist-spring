package br.com.leandro.todolist.adapters.api.requests;

import javax.validation.constraints.NotBlank;

import br.com.leandro.todolist.domain.dtos.TodoData;

public class TodoRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String description;

	public TodoRequest(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static TodoData convertToTodoData(TodoRequest request) {
		return new TodoData(request.getTitle(), request.getDescription());
	}

}
