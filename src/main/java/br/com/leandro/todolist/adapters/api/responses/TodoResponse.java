package br.com.leandro.todolist.adapters.api.responses;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.leandro.todolist.domain.entities.Todo;

public class TodoResponse {

	private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private final String id;

	private final String title;

	private final String description;

	private final String status;

	private final String createdAt;

	private final String updatedAt;

	public TodoResponse(Todo todo) {
		this.id = todo.getId().toString();
		this.title = todo.getTitle();
		this.description = todo.getDescription();
		this.status = todo.getStatus().toString();
		this.createdAt = todo.getCreatedAt().format(df).toString();
		this.updatedAt = todo.getUpdatedAt().format(df).toString();
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

	public String getStatus() {
		return status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public static Page<TodoResponse> fromTodoPage(Page<Todo> todos) {
		List<TodoResponse> todoResponseList = todos.getContent().stream().map(todo -> new TodoResponse(todo))
				.collect(Collectors.toList());

		return new PageImpl<TodoResponse>(todoResponseList, todos.getPageable(), todos.getTotalElements());
	}

}
