package br.com.leandro.todolist.domain.usecases;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.leandro.todolist.domain.ports.TodoRepository;
import br.com.leandro.todolist.domain.ports.outputs.ListTodosOutput;

public class ListTodosUnitTest {

	private TodoRepository todoRepository;

	private ListTodos listTodos;

	@BeforeEach
	void setUp() {
		todoRepository = mock(TodoRepository.class);
		ListTodosOutput viewModel = mock(ListTodosOutput.class);
		listTodos = new ListTodos(todoRepository, viewModel);
	}

	@Test
	void shouldListAllTodos() {
		Pageable pagination = PageRequest.of(0, 10, Sort.by("title"));
		listTodos.execute(pagination);
		verify(todoRepository).findAll(pagination);
	}

}
