package br.com.leandro.todolist.adapters.api.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.leandro.todolist.domain.dtos.TodoData;
import br.com.leandro.todolist.domain.enums.Status;

public class TodoRequest {

	@NotBlank
	private String title;

	@NotBlank
	private String description;

	@Pattern(regexp = "OPENED|IN_PROGRESS|COMPLETED", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String status;

	public TodoRequest(String title, String description, String status) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TodoData convert() {
		if (status != null) {
			return new TodoData(title, description, Status.valueOf(status.toUpperCase()));
		}
		return new TodoData(title, description);
	}

}
