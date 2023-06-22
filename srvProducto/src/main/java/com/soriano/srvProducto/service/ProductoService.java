package com.soriano.srvProducto.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.producto.ProductoDTO;
import com.soriano.model.entities.producto.ProductoDAO;
import com.soriano.srvProducto.commons.converter.ProductoConverter;
import com.soriano.srvProducto.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    private IProductoRepository iProductoRepository;

    private final ModelMapper modelMapper;

    private final ProductoConverter productoConverter;

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public ProductoService(IProductoRepository iProductoRepository, ModelMapper modelMapper, ProductoConverter productoConverter) {
        this.iProductoRepository = iProductoRepository;
        this.modelMapper = modelMapper;
        this.productoConverter = productoConverter;
    }

    @Override
    public GenericResponseDTO crearProducto(ProductoDTO productoDTO) throws Exception {
        try{
            ProductoDAO productoDAO = productoConverter.productoDTOtoDAO(productoDTO, modelMapper);
            System.out.println("FECHA REGISTRO: "+ productoDAO.getProductoActualizacion());
            logger.info(mapper.writeValueAsString(productoDAO));

            iProductoRepository.save(productoDAO);

            ProductoDTO productoDTORespuesta = productoConverter.productoDAOtoDTO(productoDAO, modelMapper);
            logger.info(mapper.writeValueAsString(productoDTORespuesta));
            return GenericResponseDTO.builder().message("Se registro el Producto").objectResponse(productoDTORespuesta).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al registrar Producto").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    @Override
    public GenericResponseDTO actualizarProducto(ProductoDTO productoDTO) throws Exception {
        try{
            if(productoDTO.getProductoId() != null && iProductoRepository.existsById(productoDTO.getProductoId())) {
                ProductoDAO productoDAO = productoConverter.productoDTOtoDAO(productoDTO, modelMapper);
                logger.info(mapper.writeValueAsString(productoDAO));

                iProductoRepository.save(productoDAO);

                ProductoDTO productoDTORespuesta = productoConverter.productoDAOtoDTO(productoDAO, modelMapper);
                logger.info(mapper.writeValueAsString(productoDTORespuesta));
                return GenericResponseDTO.builder().message("Se actualizo el Producto").objectResponse(productoDTORespuesta).statusCode(HttpStatus.OK.value()).build();
            }else{
                return GenericResponseDTO.builder().message("Error al actualizar el producto, NO existe").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
            }
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error al actualizar el producto").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }

    @Override
    public GenericResponseDTO listarProductos() throws Exception {
        try{
            List<ProductoDTO> listaProductosDTO = Arrays.asList(modelMapper.map(iProductoRepository.findAll(), ProductoDTO[].class));
            logger.info(mapper.writeValueAsString(listaProductosDTO));
            return GenericResponseDTO.builder().message("Listado de Productos existentes en el sistema").objectResponse(listaProductosDTO).statusCode(HttpStatus.OK.value()).build();
        }catch(Exception e){
            logger.error(e.getMessage());
            return GenericResponseDTO.builder().message("Error  al listar los Productos").objectResponse(null).statusCode(HttpStatus.BAD_REQUEST.value()).build();
        }
    }



}
