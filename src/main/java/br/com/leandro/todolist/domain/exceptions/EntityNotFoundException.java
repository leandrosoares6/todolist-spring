package br.com.leandro.todolist.domain.exceptions;

public class EntityNotFoundException extends DomainException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
