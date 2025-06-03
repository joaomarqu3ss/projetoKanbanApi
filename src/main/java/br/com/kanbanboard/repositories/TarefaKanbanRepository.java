package br.com.kanbanboard.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.kanbanboard.entities.TarefaKanban;

@Repository
public interface TarefaKanbanRepository extends JpaRepository<TarefaKanban, UUID> {
	// Custom query methods can be defined here if needed
	
	List<TarefaKanban> findAll();
	

}
