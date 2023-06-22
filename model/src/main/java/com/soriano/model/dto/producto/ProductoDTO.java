package com.soriano.model.dto.producto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.soriano.model.entities.categoriaProducto.CategoriaProductoDAO;
import com.soriano.model.entities.proveedor.ProveedorDAO;
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
@JsonPropertyOrder({"PRODUCTO_ID", "PRODUCTO_NOMBRE", "PRODUCTO_CODIGO","PRODUCTO_PRECIOCOMPRA", "PRODUCTO_PRECIOVENTA", "PRODUCTO_STOCK", "PRODUCTO_REFERENCIA", "PRODUCTO_ACTUALIZACION", "CATEGORIAPRODUCTO_ID"})
public class ProductoDTO {

    private Long productoId;

    @Size(min = 3, max = 100, message = "La longitud del nombre debe ser entre 3 y 100")
    @NotNull(message = "El nombre es requerido")
    private String productoNombre;

    @NotNull(message = "El codigo es requerido")
    private Long productoCodigo;

    @NotNull(message = "El precio de compra es requerido")
    private double productoPrecioCompra;

    @NotNull(message = "El precio de venta es requerido")
    private double productoPrecioVenta;

    @NotNull(message = "El stock es requerido")
    private int productoStock;

    @NotNull(message = "La referencia es requerida")
    private String productoReferencia;

    @JsonFormat(pattern = "yyyy-MM-ddhh:mm:ss")
    @NotNull(message = "La fecha de actualizacion es requerida")
    private Date productoActualizacion;

    @NotNull(message = "La categoria es requerida")
    private CategoriaProductoDAO categoriaProductoDAO;

    @NotNull(message = "Proveedor requerido")
    private ProveedorDAO proveedorDAO;
}
