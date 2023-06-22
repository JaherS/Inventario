package com.soriano.model.dto.categoriaProducto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CATEGORIAPRODUCTO_ID", "CATEGORIAPRODUCTO_NOMBRE", "CATEGORIAPRODUCTO_ACTUALIZACION"})

public class CategoriaProductoDTO {

    private long categoriaProductoId;

    @NotNull(message = "El nombre es requerido")
    private String categoriaProductoNombre;

    @JsonFormat(pattern = "yyyy-MM-ddhh:mm:ss")
    @NotNull(message = "La fecha es requerida")
    private Date categoriaProductoActualizacion;
}
