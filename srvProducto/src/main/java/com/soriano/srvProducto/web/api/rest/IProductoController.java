package com.soriano.srvProducto.web.api.rest;

import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.producto.ProductoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;

public interface IProductoController {

    ResponseEntity<GenericResponseDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) throws Exception;

    ResponseEntity<GenericResponseDTO> listarProductos() throws Exception;

    ResponseEntity<GenericResponseDTO> actualizarProducto(@Valid @RequestBody ProductoDTO productoDTO) throws Exception;
}
