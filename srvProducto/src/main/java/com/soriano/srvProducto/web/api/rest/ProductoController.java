package com.soriano.srvProducto.web.api.rest;


import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.producto.ProductoDTO;
import com.soriano.srvProducto.service.IProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@CrossOrigin
public class ProductoController implements IProductoController {

    @Autowired
    private IProductoService iProductoService;

    @Override
    @PostMapping(path = "/crearProducto", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Crea un Producto en el sistema", notes = "notas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "La creacion fue exitosa", response = GenericResponseDTO.class)})
    public ResponseEntity<GenericResponseDTO> crearProducto(@Valid @RequestBody @ApiParam(type = "ProductoDTO", value = "{\n" +
            "\"productoNombre\": \"Gaseosa Glacial Naranja\",\n" +
            "\"productoCodigo\": \"785968562210\",\n" +
            "\"productoPrecioCompra\": \"1500\",\n" +
            "\"productoStock\": \"15\"\n" +
            "\"productoReferencia\": \"Personal 350ml\"\n" +
            "\"productoActualizacion\": \"2022-07-1902:10:12\"\n" +
            "\"categoriaProductoId\": \"1\"\n" +
            "\"proveedorId\": \"15\"\n" +
            "}\n" +
            "\"categoriaProductoDAO\": {\n" +
            "\"categoriaProductoId\": \"15\",\n" +
            "}\n" +
            "\"proveedorDAO\": {\n" +
            "\"proveedorId\": \"2\",\n" +
            "}", required = true) ProductoDTO productoDTO) throws Exception {
        GenericResponseDTO genericResponseDTO = iProductoService.crearProducto(productoDTO);
        System.out.println("Fecha ingresada" + productoDTO.getProductoActualizacion());
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );


    }

    @Override
    @GetMapping(path = "/listarProductos")
    @ApiOperation(value = "Listar Productos", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se listo correctamente", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> listarProductos() throws Exception{

        GenericResponseDTO genericResponseDTO = iProductoService.listarProductos();
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @Override
    @PostMapping(path = "/actualizarProducto/", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Editar Productos en el sistema", notes = "notas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La actualizacion fue exitosa", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> actualizarProducto(@Valid @RequestBody @ApiParam(type = "ProductoDTO", value = "{\n" +
            "\"productoId\": \"7\",\n" +
            "\"productoNombre\": \"Gaseosa Glacial Naranja\",\n" +
            "\"productoCodigo\": \"785968562210\",\n" +
            "\"productoPrecioCompra\": \"1500\",\n" +
            "\"productoStock\": \"15\"\n" +
            "\"productoReferencia\": \"Personal 350ml\"\n" +
            "\"productoActualizacion\": \"2022-07-1902:10:12\"\n" +
            "\"categoriaProductoId\": \"1\"\n" +
            "\"proveedorId\": \"15\"\n" +
            "}\n" +
            "\"categoriaProductoDAO\": {\n" +
            "\"categoriaProductoId\": \"15\",\n" +
            "}\n" +
            "\"proveedorDAO\": {\n" +
            "\"proveedorId\": \"2\",\n" +
            "}", required = true) ProductoDTO productoDTO) throws Exception {

        GenericResponseDTO genericResponseDTO = iProductoService.actualizarProducto(productoDTO);
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        //Map<String, String> errors = MensajeGenerico.generarMensajeErrorRequest(logger, ex);
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(
                GenericResponseDTO.builder().message("Error en los datos ingresados").objectResponse(errores).statusCode(HttpStatus.NOT_FOUND.value()).build(), HttpStatus.NOT_FOUND
        );
    }
}
