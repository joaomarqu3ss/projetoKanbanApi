package br.com.kanbanboard.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TarefaKanbanRequestDto {
	@Size(min = 8, max = 150, message = "O título da tarefa deve ter entre 8 e 50 caracteres.")
	@NotEmpty(message = "Por favor, informe o título da tarefa.")
	private String titulo;
	
	@Size(min = 8, max = 150, message = "A descrição da tarefa deve ter entre 8 e 150 caracteres.")
	@NotEmpty(message = "Por favor, informe a descrição da tarefa.")
	private String descricao;
	
	@Size(min = 8, max = 25, message = "O nome do responsável deve ter entre 8 e 25 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do responsável pela tarefa.")
	private String responsavel;
	
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "A data prevista de entrega deve estar no formato YYYY-MM-DD.")
	@NotEmpty(message = "Por favor, informe a data prevista de entrega da tarefa.")
	private String dataPrevistaEntrega;
	
	@NotNull
	private Boolean iniciado;
	@NotNull
	private Boolean finalizado;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(String dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public Boolean getIniciado() {
		return iniciado;
	}

	public void setIniciado(Boolean iniciado) {
		this.iniciado = iniciado;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
}
