package br.com.leandro.todolist.domain.usecases;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.leandro.todolist.domain.ports.TodoRepository;

public class ListTodosUnitTest {

	private TodoRepository todoRepository;

	private ListTodos listTodos;

	private Map<String, String> filters = new HashMap<>();

	@BeforeEach
	void setUp() {
		todoRepository = mock(TodoRepository.class);
		listTodos = new ListTodos(todoRepository);
	}

	@Test
	void shouldListAllTodos() {
		Pageable pagination = PageRequest.of(0, 10, Sort.by("title"));
		listTodos.execute(pagination, filters);
		verify(todoRepository).findAll(pagination, filters);
	}

}
