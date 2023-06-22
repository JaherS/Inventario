package com.soriano.model.dto.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CLIENTE_ID", "CLIENTE_DOCUMENTO", "CLIENTE_NOMBRES", "CLIENTE_APELLIDOS", "CLIENTE_TELEFONO", "CLIENTE_ACTUALIZACION"})
public class ClienteDTO {

    private Long clienteId;

    @Size(min = 3, max = 18, message = "La longitud del documento debe ser entre 3 y 18")
    @Pattern(regexp = "^[0-9]*$", message = "El documento debe ser unicamente caracteres numericos")
    @NotNull(message = "El documento de la persona es requerido")
    private Long clienteDocumento;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "Los nombres solo pueden ser caracteres alfabeticos")
    @NotNull(message = "Los Nombres son requeridos")
    private String clienteNombres;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "Los apellidos solo pueden ser caracteres alfabeticos")
    @NotNull(message = "Los Apellidos son requeridos")
    private String clienteApellidos;

    @Size(min = 4, max = 18, message = "La longitud del telefono debe ser entre 4 y 18")
    @Pattern(regexp = "^[0-9]*$", message = "El telefono debe ser unicamente caracteres numericos")
    @NotNull(message = "El telefono es requerido")
    private String clienteTelefono;

    @JsonFormat(pattern = "yyyy-MM-ddhh:mm:ss")
    @NotNull(message = "La fecha de actualizacion es requerida")
    private Date clienteActualizacion;
}
