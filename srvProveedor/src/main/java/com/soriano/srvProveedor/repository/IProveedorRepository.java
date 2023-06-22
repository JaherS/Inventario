package com.soriano.srvProveedor.repository;

import com.soriano.model.entities.proveedor.ProveedorDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepository extends JpaRepository<ProveedorDAO, Long> {
}
