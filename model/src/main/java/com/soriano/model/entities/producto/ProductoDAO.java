package com.soriano.model.entities.producto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.soriano.model.entities.categoriaProducto.CategoriaProductoDAO;
import com.soriano.model.entities.proveedor.ProveedorDAO;
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
@Table(name = "PRODUCTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductoDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTO_ID")
    private Long productoId;

    @Column(name = "PRODUCTO_NOMBRE", nullable = false, length = 100, unique = true)
    private String productoNombre;

    @Column(name = "PRODUCTO_CODIGO", nullable = false, unique = true)
    private Long productoCodigo;

    @Column(name = "PRODUCTO_PRECIOCOMPRA", nullable = false)
    private double productoPrecioCompra;

    @Column(name = "PRODUCTO_PRECIOVENTA", nullable = false)
    private double productoPrecioVenta;

    @Column(name = "PRODUCTO_STOCK", nullable = false)
    private int productoStock;

    @Column(name = "PRODUCTO_REFERENCIA", nullable = false, length = 50)
    private String productoReferencia;

    @Temporal(TemporalType.DATE)
    @Column(name = "PRODUCTO_ACTUALIZACION", nullable = false)
    private Date productoActualizacion;

    @JoinColumn(name = "CATEGORIAPRODUCTO_ID", referencedColumnName = "CATEGORIAPRODUCTO_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoriaProductoDAO categoriaProductoDAO;

    @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "PROVEEDOR_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProveedorDAO proveedorDAO;
}