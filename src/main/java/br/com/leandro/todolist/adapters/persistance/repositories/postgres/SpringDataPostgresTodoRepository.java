package br.com.leandro.todolist.adapters.persistance.repositories.postgres;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.leandro.todolist.domain.entities.Todo;

@Repository
public interface SpringDataPostgresTodoRepository extends JpaRepository<Todo, UUID>, JpaSpecificationExecutor<Todo> {

}
