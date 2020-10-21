package com.group.ecommerce.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "idproduto")
	private String idProduto;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "valor_produto")
	private BigDecimal valorProduto;

	@Column(name = "disponivel")
	private Boolean disponivel;

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
}
