package br.com.leandro.todolist.domain.exceptions;

public class EntityAlreadyExistsException extends DomainException {

	private static final long serialVersionUID = 1L;

	public EntityAlreadyExistsException(String message) {
		super(message);
	}

}
