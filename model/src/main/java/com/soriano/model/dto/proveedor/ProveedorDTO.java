package com.soriano.model.dto.proveedor;


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
@JsonPropertyOrder({"PROVEEDOR_NOMBRE", "PROVEEDOR_DOCUMENTO", "PROVEEDOR_TELEFONO", "PROVEEDOR_ACTUALIZACION"})
public class ProveedorDTO {


    private Long proveedorId;

    @NotNull(message = "El nombre es requerido")
    private String proveedorNombre;

    @NotNull(message = "El documento es requerido")
    @Pattern(regexp = "^[0-9]*$", message = "El documento debe ser unicamente caracteres numericos")
    private String proveedorDocumento;

    @NotNull(message = "El telefono es requerido")
    @Size(min = 3, max = 12, message = "La longitud del telefono debe ser entre 1 y 12")
    //@Pattern(regexp = Regex.REGEX_TIPO_CALIFICACION, message = MensajeValidacion.MSN_ERROR_TIPO_CALIFICACION)
    @Pattern(regexp = "^[0-9]*$", message = "El telefono debe ser unicamente caracteres numericos")
    private String proveedorTelefono;

    @JsonFormat(pattern = "yyyy-MM-ddhh:mm:ss")
    @NotNull(message = "La fecha de actualizacion es requerida")
    private Date proveedorActualizacion;
}
