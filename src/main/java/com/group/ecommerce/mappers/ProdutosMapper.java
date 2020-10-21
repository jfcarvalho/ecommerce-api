package com.group.ecommerce.mappers;

import java.util.ArrayList;
import java.util.List;

import com.group.ecommerce.adapters.rest.v1.contracts.ClienteContract;
import com.group.ecommerce.adapters.rest.v1.contracts.ProdutoContract;
import com.group.ecommerce.models.ClienteModel;
import com.group.ecommerce.models.ProdutoModel;

public class ProdutosMapper {
	
	public static List<ProdutoContract> modelListoToContractList(List<ProdutoModel> listModel)
	{
		List<ProdutoContract> listContract = new ArrayList<>();
		for(ProdutoModel produto:listModel) {
			ProdutoContract produtoContract = new ProdutoContract();
			produtoContract.setIdProduto(produto.getIdProduto());
			produtoContract.setNome(produto.getNome());
			produtoContract.setValorProduto(produto.getValorProduto());
			produtoContract.setDisponivel(produto.getDisponivel() == true ? "Sim" : "Não" );
			listContract.add(produtoContract);
		}
		return listContract;
	}

}
