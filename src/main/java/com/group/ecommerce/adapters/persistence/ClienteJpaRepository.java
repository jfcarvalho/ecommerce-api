package com.group.ecommerce.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.ecommerce.models.ClienteModel;
import com.group.ecommerce.port.outcoming.ClienteRepository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteModel, String>,
											   ClienteRepository
{
	
}
