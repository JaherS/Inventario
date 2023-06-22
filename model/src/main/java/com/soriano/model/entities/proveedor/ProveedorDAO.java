package com.soriano.model.entities.proveedor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PROVEEDOR")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProveedorDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PROVEEDOR_ID")
    private Long proveedorId;

    @Column(name = "PROVEEDOR_NOMBRE", nullable = false, length = 250)
    private String proveedorNombre;

    @Column(name = "PROVEEDOR_DOCUMENTO", nullable = false, length = 30, unique = true)
    private String proveedorDocumento;

    @Column(name = "PROVEEDOR_TELEFONO", nullable = false, length = 250)
    private String proveedorTelefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "PROVEEDOR_ACTUALIZACION", nullable = false)
    private Date proveedorActualizacion;

}