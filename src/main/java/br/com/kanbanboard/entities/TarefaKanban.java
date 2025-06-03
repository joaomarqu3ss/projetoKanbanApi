package br.com.kanbanboard.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_kanban")
public class TarefaKanban {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private UUID id;
	@Column(name = "titulo", nullable = false)
	private String titulo;
	@Column(name = "descricao", nullable = false)
	private String descricao;
	@Column(name = "responsavel", nullable = false)
	private String responsavel;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCriacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataPrevistaEntrega;
	
	@Column(nullable = false)
	private Boolean iniciado;
	@Column(nullable = false)
	private Boolean finalizado;
	
	public TarefaKanban() {
		// TODO Auto-generated constructor stub
	}
	

	public TarefaKanban(UUID id, String titulo, String descricao, String responsavel, Date dataCriacao,
			Date dataPrevistaEntrega, Boolean iniciado, Boolean finalizado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.responsavel = responsavel;
		this.dataCriacao = dataCriacao;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.iniciado = iniciado;
		this.finalizado = finalizado;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
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
