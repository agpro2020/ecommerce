package com.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductoModel {

        private String nombre;
        private  double precio;
        private boolean disponiblidad;
        private String garantia;
        private  String color;
        private boolean nuevo;
        private Date fechaCreacion;
}
