package com.ecommerce.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "detalle")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "COLOR")
    String color;
    @Column(name = "NUEVO")
    private boolean nuevo;
    @Column(name = "FECHA_FABRICACION")
    Date fechaCreacion;
    

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

}

/*
Aquí, estamos configurando la relación en la entidad Detalle.
La anotación @OneToOne indica que es una relación uno a uno. fetch = FetchType.LAZY especifica que
 la carga de la entidad Producto se realizará de forma diferida, es decir, solo se cargará cuando
 se acceda a ella. @JoinColumn se utiliza para especificar la columna que se utilizará para mapear
 la relación. En este caso, name = "id_producto" indica que se utilizará la columna id_producto en
  la tabla detalle para almacenar el ID del Producto. referencedColumnName = "id"
 indica que se utilizará la columna id en la tabla producto como referencia para la relación.
* */

