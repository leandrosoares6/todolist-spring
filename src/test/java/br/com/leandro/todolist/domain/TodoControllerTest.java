package br.com.leandro.todolist.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import br.com.leandro.todolist.adapters.api.responses.TodoResponse;
import br.com.leandro.todolist.domain.entities.Todo;

@SpringBootTest
@TestPropertySource(properties = { "DB_NAME=todolist_test", "spring.jpa.hibernate.ddlAuto:create-drop" })
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
@Transactional
public class TodoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestEntityManager entityManager;

	private Todo todo;

	private TodoResponse todoResponse;

	@BeforeEach
	void setup() {
		todo = new Todo("test of any to do", "testing the creation of any to do");
		entityManager.persist(todo);
		todoResponse = new TodoResponse(todo);
	}

	@Test
	void shouldReturn404WhenNotExistTodoById() throws Exception {
		mockMvc.perform(get("/todos/ABC")).andExpect(status().isNotFound());
	}

	@Test
	void shouldReturnAnTodoById() throws Exception {
		mockMvc.perform(get("/todos/" + todo.getId().toString())).andExpect(status().isOk()).andDo(log())
				.andExpect(jsonPath("$.id", equalTo(todo.getId().toString())))
				.andExpect(jsonPath("$.title", equalTo(todo.getTitle())))
				.andExpect(jsonPath("$.description", equalTo(todo.getDescription())))
				.andExpect(jsonPath("$.status", equalTo(todo.getStatus().toString())))
				.andExpect(jsonPath("$.description", equalTo(todo.getDescription())))
				.andExpect(jsonPath("$.createdAt", equalTo(todoResponse.getCreatedAt())))
				.andExpect(jsonPath("$.updatedAt", equalTo(todoResponse.getUpdatedAt())));
	}

	@Test
	void shouldReturnHttpStatus201WithHeaderAttributeLocationAndTodoResourceInBodyWhenValidRequestIsFormed()
			throws Exception {
		String todoJson = "{ \"title\": \"To do test\", \"description\": \"My todo test\" }";
		mockMvc.perform(post("/todos/").contentType(MediaType.APPLICATION_JSON).content(todoJson))
				.andExpect(status().isCreated()).andExpect(header().exists("location"))
				.andExpect(jsonPath("$.title", equalTo("To do test")))
				.andExpect(jsonPath("$.description", equalTo("My todo test")));
	}

}
