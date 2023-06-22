package com.soriano.model.entities.detalleFactura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.soriano.model.entities.factura.FacturaDAO;
import com.soriano.model.entities.producto.ProductoDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DETALLEFACTURA")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetalleFacturaDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DETALLEFACTURA_ID")
    private Long detalleFacturaId;

    @Column(name = "DETALLEFACTURA_PRECIO", nullable = false)
    private double detalleFacturaPrecio;

    @Column(name = "DETALLEFACTURA_DESCUENTO")
    private double detalleFacturaDescuento;


    @Column(name = "DETALLEFACTURA_CANTIDAD", nullable = false)
    private Long detalleFacturaCantidad;

    @Temporal(TemporalType.DATE)
    @Column(name = "DETALLEFACTURA_ACTUALIZACION", nullable = false)
    private Date detalleFacturaActualizacion;

    //relaciones
    @JoinColumn(name = "FACTURA_ID", referencedColumnName = "FACTURA_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private FacturaDAO facturaDAO;

    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "PRODUCTO_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductoDAO productoDAO;
}
