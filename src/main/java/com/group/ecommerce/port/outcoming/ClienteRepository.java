package com.group.ecommerce.port.outcoming;


import java.util.List;
import java.util.Optional;

import com.group.ecommerce.models.ClienteModel;

public interface ClienteRepository {
	public List<ClienteModel> findAllByStatusOrderByIdClienteAsc(String status);
	public List<ClienteModel> findAllByStatusOrderByIdClienteDesc(String status);
	public Optional<ClienteModel> findByIdCliente(String idCliente); 
}
