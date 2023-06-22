package com.soriano.model.entities.cliente;

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
@Table(name = "CLIENTE")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLIENTE_ID")
    private Long clienteId;

    @Column(name = "CLIENTE_NOMBRES", nullable = false, length = 250)
    private String clienteNombres;

    @Column(name = "CLIENTE_APELLIDOS", nullable = false, length = 250)
    private String clienteApellidos;

    @Column(name = "CLIENTE_DOCUMENTO", nullable = false, length = 30, unique = true)
    private String clienteDocumento;

    @Column(name = "CLIENTE_TELEFONO", nullable = false, length = 250)
    private String clienteTelefono;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLIENTE_ACTUALIZACION", nullable = false)
    private Date clienteActualizacion;

}
