package br.com.leandro.todolist.adapters.persistance.repositories.postgres.specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.leandro.todolist.domain.entities.Todo;

public class TodoSpecifications {

	public static Specification<Todo> likeTitle(String title) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + title + "%");
	}

	public static Specification<Todo> likeDescription(String description) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),
				"%" + description + "%");
	}

	public static Specification<Todo> likeTitleOrDescription(String title, String description) {
		return Specification.where(likeTitle(title).or(likeDescription(description)));
	}

}
