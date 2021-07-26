package br.com.leandro.todolist.domain.exceptions;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DomainException() {
	}

	public DomainException(String message) {
		super(message);
	}

}
