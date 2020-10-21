package com.group.ecommerce.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group.ecommerce.validators.StatusAtivoInativo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDomainAlterar {
	
	@NotNull
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("data-cadastro")
	private String dataCadastro;
	
	@StatusAtivoInativo
	@JsonProperty("status")
	private String status;

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
