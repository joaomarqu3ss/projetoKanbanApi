package br.com.kanbanboard.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kanbanboard.dtos.TarefaKanbanRequestDto;
import br.com.kanbanboard.dtos.TarefaKanbanResponseDto;
import br.com.kanbanboard.entities.TarefaKanban;
import br.com.kanbanboard.repositories.TarefaKanbanRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/kanban/tarefas")
@Tag(name = "Tarefa Kanban", description = "Serviço para operações relacionadas a tarefas no Kanban.")
public class TarefaKanbanController {
	@Autowired TarefaKanbanRepository tarefaKanbanRepository;
	@Autowired ModelMapper mapper;
	
	
	@Operation(summary = "Criação de tarefa Kanban", description = "Cria uma nova tarefa Kanban no sistema.")
	@PostMapping
	public TarefaKanbanResponseDto post(@RequestBody @Valid TarefaKanbanRequestDto request) {
		var tarefa = mapper.map(request, TarefaKanban.class);
		tarefa.setId(UUID.randomUUID()); // Gerando um ID único para a tarefa
		tarefa.setDataCriacao(new Date()); // Definindo a data de criação como a data atual
		tarefaKanbanRepository.save(tarefa); // Salvando a tarefa no repositório
		return mapper.map(tarefa, TarefaKanbanResponseDto.class); // Convertendo a entidade para DTO e retornando
	}
	
	@Operation(summary = "Atualiza uma tarefa Kanban", description = "Atualiza os dados de uma tarefa Kanban existente.")
	@PutMapping("{id}")
	public TarefaKanbanResponseDto put(@PathVariable UUID id,@RequestBody @Valid TarefaKanbanRequestDto request) {
		if(!tarefaKanbanRepository.existsById(id)) 
			throw new IllegalArgumentException("Tarefa Kanban não encontrada. Verifique o ID informado.");
		var tarefa = mapper.map(request, TarefaKanban.class);
		tarefa.setId(id); // Mantendo o ID da tarefa existente
		tarefa.setDataCriacao(tarefaKanbanRepository.findById(id).get().getDataCriacao()); // Mantendo a data de criação
		tarefaKanbanRepository.save(tarefa); // Salvando a tarefa atualizada no repositório
		return mapper.map(tarefa, TarefaKanbanResponseDto.class); // Convertendo a entidade para DTO e retornando
		
		
	}
	
	@Operation(summary = "Exclusão de tarefa Kanban", description = "Remove uma tarefa Kanban do sistema.")
	@DeleteMapping("{id}")
	public TarefaKanbanResponseDto delete(@PathVariable UUID id) {
	
		var tarefa = tarefaKanbanRepository.findById(id).
				orElseThrow(() -> new IllegalArgumentException("Tarefa Kanban não encontrada. Verifique o ID informado."));
		tarefaKanbanRepository.delete(tarefa); // Excluindo a tarefa do repositório
		return mapper.map(tarefa, TarefaKanbanResponseDto.class); // Convertendo a entidade para DTO e retornando
	}
	
	
	@Operation(summary = "Consulta de tarefa Kanban", description = "Obtém os dados de uma tarefa Kanban existente.")
	@GetMapping
	public List<TarefaKanbanResponseDto> get() {
		var tarefas = tarefaKanbanRepository.findAll(); // Obtendo todas as tarefas do repositório
		return tarefas.stream()
				.map(tarefakanban -> mapper.map(tarefakanban, TarefaKanbanResponseDto.class)) // Convertendo cada tarefa para DTO
				.toList(); // Retornando a lista de DTOs
		
		
	}
	
}
