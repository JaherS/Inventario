package com.soriano.srvProveedor.web.api.rest;

import com.soriano.model.dto.generic.GenericResponseDTO;
import com.soriano.model.dto.proveedor.ProveedorDTO;
import com.soriano.srvProveedor.service.IProveedorService;
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
public class ProveedorController implements IProveedorController {

    @Autowired
    private IProveedorService iProveedorService;

    @Override
    @PostMapping(path = "/crearProveedor", produces = "application/json", consumes = "application/json")
    @ApiOperation(value = "Crea un Proveedor en el sistema", notes = "notas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "La creacion fue exitosa", response = GenericResponseDTO.class)})
    public ResponseEntity<GenericResponseDTO> crearProveedor(@Valid @RequestBody @ApiParam(type = "ProveedorDTO", value = "{\n" +
            "\"proveedorNombre\": \"Distribuidora Ejemplo\",\n" +
            "\"proveedorDocumento\": \"123456\",\n" +
            "\"proveedorTelefono\": \"3208205334\",\n" +
            "\"proveedorActualizacion\": \"2022-07-1902:10:12\"\n" +
            "}", required = true) ProveedorDTO proveedorDTO) throws Exception {
        GenericResponseDTO genericResponseDTO = iProveedorService.crearProveedor(proveedorDTO);
        System.out.println("Fecha ingresada" + proveedorDTO.getProveedorActualizacion());
        return new ResponseEntity(
                genericResponseDTO, HttpStatus.valueOf(genericResponseDTO.getStatusCode())
        );


    }

    @Override
    @GetMapping(path = "/listarProveedores")
    @ApiOperation(value = "Listar Proveedores", notes = "notas")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Se listo correctamente", response = GenericResponseDTO.class)
    })
    public ResponseEntity<GenericResponseDTO> listarProveedores() throws Exception{

        GenericResponseDTO genericResponseDTO = iProveedorService.listarProveedores();
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
