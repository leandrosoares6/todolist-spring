package br.com.leandro.todolist.domain.dtos;

import br.com.leandro.todolist.domain.enums.Status;

public class TodoData {

	private String title;

	private String description;

	private Status status;

	public TodoData(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public TodoData(String title, String description, Status status) {
		this.title = title;
		this.description = description;
		this.status = status;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
