package com.group.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group.ecommerce.adapters.persistence.PedidoJpaRepository;
import com.group.ecommerce.adapters.rest.v1.contracts.PedidoContract;
import com.group.ecommerce.mappers.PedidoMapper;
import com.group.ecommerce.models.PedidoModel;

@Service
public class PedidoService {

	@Autowired
	private PedidoJpaRepository pedidoRepository;
	
	public List<PedidoContract> buscarPedidos(String statusEntrega) {
		List<PedidoModel> listaPedidos = pedidoRepository.buscarPorStatusEntrega(statusEntrega);
		return PedidoMapper.modelListoToContractList(listaPedidos);
	}
	
	
}
