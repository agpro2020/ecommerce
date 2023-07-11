package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private  Double precio;

    @Column(name = "disponibilidad")
    private boolean disponiblidad;

    @Column(name = "garantia")
    private String garantia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id_producto")
    private Detalle detalle;

    /*Aquí, estamos configurando la relación en la entidad Producto.
    Al utilizar la anotación @OneToOne, indicamos que
     es una relación uno a uno. cascade = CascadeType.ALL especifica que todas las operaciones de cascada se
     aplicarán a la entidad Detalle.
     @JoinColumn se utiliza para especificar la columna que se utilizará para mapear la relación.
      En este caso, name = "id" indica que se utilizará la columna id en la tabla producto para almacenar el
      ID del Producto. referencedColumnName = "id_producto" indica que se utilizará la columna id_producto en
       la tabla detalle como referencia para la relación.
        Con estos cambios, se establece la relación uno a uno entre
        Producto y Detalle, y el ID del Producto se guarda en la columna id_producto en la tabla detalle.*/



}
