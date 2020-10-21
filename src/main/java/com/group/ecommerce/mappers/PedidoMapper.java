package com.group.ecommerce.mappers;

import java.util.ArrayList;
import java.util.List;

import com.group.ecommerce.adapters.rest.v1.contracts.PedidoContract;
import com.group.ecommerce.adapters.rest.v1.contracts.ProdutoContract;
import com.group.ecommerce.models.PedidoModel;
import com.group.ecommerce.models.ProdutoModel;

public class PedidoMapper {
	
	public static List<PedidoContract> modelListoToContractList(List<PedidoModel> listModel)
	{
		List<PedidoContract> listContract = new ArrayList<>();
		for(PedidoModel pedido:listModel) {
			PedidoContract pedidoContract = new PedidoContract();
			pedidoContract.setIdPedido(pedido.getIdPedido());
			pedidoContract.setIdCliente(pedido.getCliente().getIdCliente());
			pedidoContract.setDataCadastro (pedido.getDataCadastro());
			pedidoContract.setStatusEntrega(pedido.getStatusEntrega());
			List<ProdutoContract> produtosContracts = new ArrayList<>();
			
			for(ProdutoModel produto:pedido.getProdutos()) 
			{
				ProdutoContract produtoContract = new ProdutoContract();
				produtoContract.setNome(produto.getNome());
				produtoContract.setIdProduto(produto.getIdProduto());
				produtoContract.setDisponivel(produto.getDisponivel());
				produtoContract.setValorProduto(produto.getValorProduto());
				produtosContracts.add(produtoContract);
			}
			
			pedidoContract.setProdutos(produtosContracts);
			listContract.add(pedidoContract);
		}
		return listContract;
	}

}
