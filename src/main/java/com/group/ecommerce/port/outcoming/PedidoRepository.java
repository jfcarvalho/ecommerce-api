package com.group.ecommerce.port.outcoming;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.group.ecommerce.models.PedidoModel;

public interface PedidoRepository {
	
	@Query(value = "SELECT p FROM PedidoModel p INNER JOIN FETCH p.cliente INNER JOIN FETCH p.produtos where p.statusEntrega = :status")
	public List<PedidoModel> buscarPorStatusEntrega(@Param("status") String statusEntrega);
	
	@Query(value = "SELECT p FROM PedidoModel p INNER JOIN FETCH p.cliente INNER JOIN FETCH p.produtos where p.cliente.idCliente = :idcliente")
	public List<PedidoModel> buscarPorIdCliente(@Param("idcliente") String idCliente);

}
