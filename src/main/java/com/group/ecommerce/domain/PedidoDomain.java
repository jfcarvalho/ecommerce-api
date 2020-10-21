package com.group.ecommerce.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDomain {
	
	@JsonProperty("id")
	private String idPedido;
	
	@JsonProperty("data_cadastro")
	private String dataCadastro;
	
	@JsonProperty("idCliente")
	private String idCliente;

	@JsonProperty("status-entrega")
	private String statusEntrega;
	
	@JsonProperty("produtos")
	private List<ProdutoDomain> produtos;

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public List<ProdutoDomain> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoDomain> produtos) {
		this.produtos = produtos;
	}
}