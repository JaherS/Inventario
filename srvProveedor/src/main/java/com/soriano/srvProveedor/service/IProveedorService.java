package com.soriano.srvProveedor.service;

import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.proveedor.ProveedorDTO;

public interface IProveedorService {
    GenericResponseDTO crearProveedor(ProveedorDTO proveedorDTO) throws Exception;

    GenericResponseDTO listarProveedores() throws Exception;
}
