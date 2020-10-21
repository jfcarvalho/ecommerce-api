package com.group.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce.adapters.persistence.ProdutoJpaRepository;
import com.group.ecommerce.adapters.rest.v1.contracts.ProdutoContract;
import com.group.ecommerce.mappers.ProdutosMapper;
import com.group.ecommerce.models.ProdutoModel;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoJpaRepository produtosRepository;
	
	public List<ProdutoContract> listarProdutos() {
		List<ProdutoModel> produtos = produtosRepository.findAll();
		return ProdutosMapper.modelListoToContractList(produtos);
	}

}
