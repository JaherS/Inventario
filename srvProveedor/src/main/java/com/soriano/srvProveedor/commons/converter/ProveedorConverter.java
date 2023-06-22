package com.soriano.srvProveedor.commons.converter;


import com.soriano.model.dto.proveedor.ProveedorDTO;
import com.soriano.model.entities.proveedor.ProveedorDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProveedorConverter {

    public ProveedorDAO proveedorDTOtoDAO(ProveedorDTO proveedorDTO, ModelMapper modelMapper){
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        modelMapper.map(proveedorDTO, proveedorDAO);
        return proveedorDAO;
    }


    public ProveedorDTO proveedorDAOtoDTO(ProveedorDAO proveedorDAO, ModelMapper modelMapper){
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        modelMapper.map(proveedorDAO, proveedorDTO);
        return proveedorDTO;
    }
}
