package com.group.ecommerce.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import com.group.ecommerce.adapters.rest.v1.contracts.ClienteContract;
import com.group.ecommerce.domain.ClienteDomain;
import com.group.ecommerce.domain.ClienteDomainAlterar;
import com.group.ecommerce.models.ClienteModel;


public class ClienteMapper {
	public static List<ClienteContract> modelListoToContractList(List<ClienteModel> listModel)
	{
		List<ClienteContract> listContract = new ArrayList<>();
		for(ClienteModel cliente:listModel) {
			ClienteContract clienteContract = new ClienteContract();
			clienteContract.setIdCliente(cliente.getIdCliente());
			clienteContract.setNome(cliente.getNome());
			clienteContract.setDataCadastro(cliente.getDataCadastro());
			clienteContract.setStatus(cliente.getStatus());
			listContract.add(clienteContract);
		}
		return listContract;
	}
	
	public static ClienteModel domainToModel(ClienteDomain domain) {
		ClienteModel clienteModel = new ClienteModel();
		clienteModel.setNome(domain.getNome());
		clienteModel.setDataCadastro(domain.getDataCadastro());
		clienteModel.setStatus(domain.getStatus());
		clienteModel.setIdCliente(domain.getId());
		return clienteModel;
	}
	
	public static ClienteContract modelToContract(ClienteModel model) {
		ClienteContract clienteContract = new ClienteContract();
		clienteContract.setIdCliente(model.getIdCliente());
		clienteContract.setNome(model.getNome());
		clienteContract.setDataCadastro(model.getDataCadastro());
		clienteContract.setStatus(model.getStatus());
		
		return clienteContract;
	}
	
	public static ClienteModel domainToModelPut(ClienteDomainAlterar domain, ClienteModel clienteBanco) {
		ClienteModel clienteModel = new ClienteModel();
		clienteModel.setIdCliente(clienteBanco.getIdCliente());
		clienteModel.setNome(domain.getNome() != null ? domain.getNome() : clienteBanco.getNome());
		clienteModel.setDataCadastro(domain.getDataCadastro() != null ? domain.getDataCadastro() : clienteBanco.getDataCadastro());
		clienteModel.setStatus(domain.getStatus() != null ? domain.getStatus() : clienteBanco.getStatus());
		
		return clienteModel;
	}
	

}
