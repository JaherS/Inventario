package com.soriano.model.dto.detalleFactura;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.soriano.model.entities.factura.FacturaDAO;
import com.soriano.model.entities.producto.ProductoDAO;
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
@JsonPropertyOrder({"DETALLEFACTURA_ID", "DETALLEFACTURA_PRECIO", "DETALLEFACTURA_CANTIDAD", "DETALLEFACTURA_DESCUENTO", "FACTURA_ID", "PRODUCTO_ID", "DETALLEFACTURA_ACTUALIZACION"})
public class DetalleFacturaDTO {

    private Long detalleFacturaId;

    @NotNull(message = "El precio es requerido")
    private double detalleFacturaPrecio;

    private double detalleFacturaDescuento;

    @NotNull(message = "La cantidad es requerida")
    private Long detalleFacturaCantidad;

    @JsonFormat(pattern = "yyyy-MM-ddhh:mm:ss")
    @NotNull(message = "La fecha de actualizacion es requerida")
    private Date detalleFacturaActualizacion;

    @NotNull(message = "La factura es requerida")
    private FacturaDAO facturaDAO;

    @NotNull(message = "El producto es requerido")
    private ProductoDAO productoDAO;


}
