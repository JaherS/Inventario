package com.soriano.srvProveedor.web.api.rest;

import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.proveedor.ProveedorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

public interface IProveedorController {

    ResponseEntity<GenericResponseDTO> crearProveedor(@Valid @RequestBody  ProveedorDTO proveedorDTO) throws Exception;


    ResponseEntity<GenericResponseDTO> listarProveedores() throws Exception;
}
