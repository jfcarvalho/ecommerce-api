package com.group.ecommerce.mappers;

import java.util.ArrayList;
import java.util.List;

import com.group.ecommerce.adapters.rest.v1.contracts.ClienteContract;
import com.group.ecommerce.adapters.rest.v1.contracts.PedidoContract;
import com.group.ecommerce.adapters.rest.v1.contracts.ProdutoContract;
import com.group.ecommerce.domain.PedidoDomain;
import com.group.ecommerce.domain.ProdutoDomain;
import com.group.ecommerce.models.ClienteModel;
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
	
	public static PedidoModel domainToModel (PedidoDomain domain, ClienteModel cliente) {
		PedidoModel model = new PedidoModel();
		model.setDataCadastro(domain.getDataCadastro());
		model.setIdPedido(domain.getIdPedido());
		model.setStatusEntrega(domain.getStatusEntrega());
		
		ClienteModel clienteModel = new ClienteModel();
		clienteModel.setNome(cliente.getNome());
		clienteModel.setIdCliente(cliente.getIdCliente());
		clienteModel.setDataCadastro(cliente.getDataCadastro());
		clienteModel.setStatus(cliente.getStatus());
		model.setCliente(clienteModel);
		
		List<ProdutoModel> produtosModel = new ArrayList<>();
		for(ProdutoDomain produtoDomain:domain.getProdutos()) {
			ProdutoModel produtoModel = new ProdutoModel();
			produtoModel.setIdProduto(produtoDomain.getIdProduto());
			produtoModel.setNome(produtoDomain.getNome());
			produtoModel.setDisponivel(produtoDomain.getDisponivel());
			produtoModel.setValorProduto(produtoDomain.getValorProduto());
			produtosModel.add(produtoModel);
		}
		model.setProdutos(produtosModel);
		return model;
	}
	
	public static PedidoContract modelToContract (PedidoModel model) {
		PedidoContract contract = new PedidoContract();
		contract.setDataCadastro(model.getDataCadastro());
		contract.setIdPedido(model.getIdPedido());
		contract.setStatusEntrega(model.getStatusEntrega());
		
		contract.setIdCliente(model.getCliente().getIdCliente());
		
		List<ProdutoContract> produtosContract = new ArrayList<>();
		for(ProdutoModel produtoModel:model.getProdutos()) {
			ProdutoContract produtoContract = new ProdutoContract();
			produtoContract.setIdProduto(produtoModel.getIdProduto());
			produtoContract.setNome(produtoModel.getNome());
			produtoContract.setDisponivel(produtoModel.getDisponivel());
			produtoContract.setValorProduto(produtoModel.getValorProduto());
			produtosContract.add(produtoContract);
		}
		contract.setProdutos(produtosContract);
	
		return contract;
	}

}
