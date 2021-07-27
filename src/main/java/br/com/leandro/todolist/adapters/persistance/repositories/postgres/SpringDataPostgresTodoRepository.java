package br.com.leandro.todolist.adapters.persistance.repositories.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leandro.todolist.domain.entities.Todo;

@Repository
public interface SpringDataPostgresTodoRepository extends JpaRepository<Todo, String> {

	public Todo findByTitle(String title);

	public Todo findByDescription(String description);

}
