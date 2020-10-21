package com.group.ecommerce.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.group.ecommerce.models.ProdutoModel;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoModel, String> {

}
