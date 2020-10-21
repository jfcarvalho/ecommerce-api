package com.group.ecommerce.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.ecommerce.models.PedidoModel;
import com.group.ecommerce.port.outcoming.PedidoRepository;

@Repository
public interface PedidoJpaRepository extends JpaRepository<PedidoModel, String>, PedidoRepository {

}
