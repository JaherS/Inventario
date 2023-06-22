package com.soriano.model.entities.factura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.soriano.model.entities.cliente.ClienteDAO;
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
@Table(name = "FACTURA")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FacturaDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FACTURA_ID")
    private Long facturaId;

    @Temporal(TemporalType.DATE)
    @Column(name = "FACTURA_FECHA", nullable = false)
    private Date facturaFecha;

    @Column(name = "FACTURA_TOTAL", nullable = false)
    private double facturaTotal;

    @Column(name = "FACTURA_IMPUESTO", nullable = false)
    private double facturaImpuesto;

    @Column(name = "FACTURA_ESTADO", nullable = false, length = 50)
    private String facturaEstado;

    @Temporal(TemporalType.DATE)
    @Column(name = "FACTURA_ACTUALIZACION", nullable = false)
    private Date facturaActualizacion;

    //relaciones
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteDAO clienteDAO;
}
