package com.soriano.model.entities.categoriaProducto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "CATEGORIAPRODUCTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriaProductoDAO implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CATEGORIAPRODUCTO_ID")
    private Long categoriaProductoId;

    @Column(name = "CATEGORIAPRODUCTO_NOMBRE", nullable = false, length = 50, unique = true)
    private String categoriaProductoNombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "CATEGORIAPRODUCTO_ACTUALIZACION", nullable = false)
    private Date categoriaProductoActualizacion;

}
