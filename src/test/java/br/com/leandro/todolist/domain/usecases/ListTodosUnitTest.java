package br.com.leandro.todolist.domain.usecases;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leandro.todolist.domain.ports.ITodoRepository;
import br.com.leandro.todolist.domain.ports.outputs.IListTodosOutput;

public class ListTodosUnitTest {

	private ITodoRepository todoRepository;

	private ListTodos listTodos;

	@BeforeEach
	void setUp() {
		todoRepository = mock(ITodoRepository.class);
		IListTodosOutput viewModel = mock(IListTodosOutput.class);
		listTodos = new ListTodos(todoRepository, viewModel);
	}

	@Test
	void shouldListAllTodos() {
		listTodos.execute(Optional.of(1), Optional.of(10));
		verify(todoRepository).findAll(1, 10);
	}

}
