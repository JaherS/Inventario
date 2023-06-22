package com.soriano.srvProducto.commons.converter;

import com.soriano.model.dto.producto.ProductoDTO;
import com.soriano.model.entities.producto.ProductoDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductoConverter {

    public ProductoDAO productoDTOtoDAO(ProductoDTO productoDTO, ModelMapper modelMapper){
        ProductoDAO productoDAO = new ProductoDAO();
        modelMapper.map(productoDTO, productoDAO);
        return productoDAO;
    }


    public ProductoDTO productoDAOtoDTO(ProductoDAO productoDAO, ModelMapper modelMapper){
        ProductoDTO productoDTO = new ProductoDTO();
        modelMapper.map(productoDAO, productoDTO);
        return productoDTO;
    }
}
