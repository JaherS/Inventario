package com.soriano.srvProducto.service;

import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.producto.ProductoDTO;

public interface IProductoService {
    GenericResponseDTO crearProducto(ProductoDTO productoDTO) throws Exception;

    GenericResponseDTO actualizarProducto(ProductoDTO productoDTO) throws Exception;

    GenericResponseDTO listarProductos() throws Exception;
}
