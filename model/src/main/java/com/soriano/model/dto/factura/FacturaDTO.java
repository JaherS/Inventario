package com.soriano.model.dto.factura;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.soriano.model.entities.cliente.ClienteDAO;
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
@JsonPropertyOrder({"FACTURA_ID", "FACTURA_FECHA", "FACTURA_TOTAL", "FACTURA_IMPUESTO", "FACTURA_ESTADO", "FACTURA_ACTUALIZACION", "CLIENTE_ID"})
public class FacturaDTO {

    private Long facturaId;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @NotNull(message = "La fecha es requerida")
    private Date facturaFecha;

    @NotNull(message = "El total es requerido")
    private double facturaTotal;

    @NotNull(message = "El impuesto es requerido")
    private double facturaImpuesto;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "El estado debe ser solo caracteres de tipo letras")
    @NotNull(message = "El estado es requerido")
    private String facturaEstado;

    @JsonFormat(pattern = "yyyy-MM-ddhh:mm:ss")
    @NotNull(message = "La fecha de actualizacion es requerida")
    private Date facturaActualizacion;

    @NotNull(message = "El cliente es requerido")
    private ClienteDAO clienteDAO;

}
