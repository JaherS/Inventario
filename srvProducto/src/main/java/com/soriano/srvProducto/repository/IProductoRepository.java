package com.soriano.srvProducto.repository;

import com.soriano.model.entities.producto.ProductoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoDAO, Long> {
}
