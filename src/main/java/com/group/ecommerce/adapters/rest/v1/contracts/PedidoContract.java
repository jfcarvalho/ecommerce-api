package com.group.ecommerce.adapters.rest.v1.contracts;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group.ecommerce.models.ProdutoModel;

public class PedidoContract {
	
	@JsonProperty("id")
	private String idPedido;
	
	@JsonProperty("data_cadastro")
	private String dataCadastro;
	
	@JsonProperty("idCliente")
	private String idCliente;

	@JsonProperty("status-entrega")
	private String statusEntrega;
	
	@JsonProperty("produtos")
	private List<ProdutoContract> produtos;

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

	public List<ProdutoContract> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoContract> produtos) {
		this.produtos = produtos;
	}
	
}
