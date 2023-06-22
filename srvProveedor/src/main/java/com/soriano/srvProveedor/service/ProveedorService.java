package com.soriano.srvProveedor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.proveedor.ProveedorDTO;
import com.soriano.model.entities.proveedor.ProveedorDAO;
import com.soriano.srvProveedor.commons.converter.ProveedorConverter;
import com.soriano.srvProveedor.repository.IProveedorRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    private IProveedorRepository iProveedorRepository;

    private final ModelMapper modelMapper;

    private final ProveedorConverter proveedorConverter;

    private static final Logger logger = LoggerFactory.getLogger(ProveedorService.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ProveedorService(IProveedorRepository iProveedorRepository, ModelMapper modelMapper, ProveedorConverter proveedorConverter) {
        this.iProveedorRepository = iProveedorRepository;
        this.modelMapper = modelMapper;
        this.proveedorConverter = proveedorConverter;
    }

    @Override
    public GenericResponseDTO crearProveedor(ProveedorDTO proveedorDTO) throws Exception {
        try{
            ProveedorDAO proveedorDAO = proveedorConverter.proveedorDTOtoDAO(proveedorDTO, modelMapper);
            System.out.println("FECHA REGISTRO: "+ proveedorDAO.getProveedorActualizacion());
            logger.info(mapper.writeValueAsString(proveedorDAO));

            iProveedorRepository.save(proveedorDAO);

            ProveedorDTO proveedorDTORespuesta = proveedorConverter.proveedorDAOtoDTO(proveedorDAO, modelMapper);
            logger.info(mapper.writeValueAsString(proveedorDTORespuesta));
            return GenericResponseDTO.builder().message("Se registro el Proveedor").objectResponse(proveedorDTORespuesta).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al registrar Proveedor").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    @Override
    public GenericResponseDTO listarProveedores() throws Exception {
        try{
            List<ProveedorDTO> listaProveedoresDTO = Arrays.asList(modelMapper.map(iProveedorRepository.findAll(), ProveedorDTO[].class));
            logger.info(mapper.writeValueAsString(listaProveedoresDTO));
            return GenericResponseDTO.builder().message("Listado Proveedores existentes en el sistema").objectResponse(listaProveedoresDTO).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error  al listar los Proveedores").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

}
