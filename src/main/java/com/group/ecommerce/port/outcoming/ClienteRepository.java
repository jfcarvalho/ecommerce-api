package com.group.ecommerce.port.outcoming;


import java.util.List;
import java.util.Optional;

import com.group.ecommerce.models.ClienteModel;

public interface ClienteRepository {
	public List<ClienteModel> findAllByStatus(String status);
	public Optional<ClienteModel> findByIdCliente(String idCliente); 
}
