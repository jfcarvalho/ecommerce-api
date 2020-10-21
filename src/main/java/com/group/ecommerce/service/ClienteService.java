package com.group.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce.adapters.persistence.ClienteJpaRepository;
import com.group.ecommerce.adapters.rest.v1.contracts.ClienteContract;
import com.group.ecommerce.domain.ClienteDomain;
import com.group.ecommerce.mappers.ClienteMapper;
import com.group.ecommerce.models.ClienteModel;
import org.springframework.beans.BeanUtils;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteJpaRepository clienteRepository;

	public List<ClienteContract> listarClientes(String status) {
		
		List<ClienteModel> clientes = clienteRepository.findAllByStatus(status);
		return ClienteMapper.modelListoToContractList(clientes);
	}
	
	public ClienteContract criarCliente(ClienteDomain cliente) {
		ClienteModel clienteOp = clienteRepository.save(ClienteMapper.domainToModel(cliente));
		return ClienteMapper.modelToContract(clienteOp);
	}
	
	public ClienteContract obterCliente(String idCliente) {
		Optional<ClienteModel> clienteOp = clienteRepository.findByIdCliente(idCliente);
		if(clienteOp.isEmpty()) {
			return null;
		}
		return ClienteMapper.modelToContract(clienteOp.get());
	}
	
	public ClienteContract atualizarCliente(String idCliente, ClienteDomain cliente) {
		Optional<ClienteModel> clienteOp = clienteRepository.findByIdCliente(idCliente);
		if(clienteOp.isPresent()) {
			ClienteModel clienteParaAtualizar = ClienteMapper.domainToModelPut(cliente);
			clienteRepository.save(clienteParaAtualizar);
			return ClienteMapper.modelToContract(clienteParaAtualizar);
		}
		
		return null;
		
	}
	

	
}
