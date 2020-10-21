package com.group.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDomain {
	
	@JsonProperty("id")
	private String idCliente;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("data-cadastro")
	private String dataCadastro;
	
	@JsonProperty("status")
	private String status;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
