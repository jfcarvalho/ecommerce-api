package com.group.ecommerce.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idpedido")
	private String idPedido;
	
	@Column(name = "data_cadastro")
	private String dataCadastro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcliente", nullable=false)
	private ClienteModel cliente;

	@Column(name = "status_entrega")
	private String statusEntrega;
	
	@ManyToMany
	@JoinTable(name ="pedido_produto",
	joinColumns = @JoinColumn(name="id_pedido"),
	inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private List<ProdutoModel> produtos = new ArrayList<>();

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public String getStatusEntrega() {
		return statusEntrega;
	}

	public void setStatusEntrega(String statusEntrega) {
		this.statusEntrega = statusEntrega;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
