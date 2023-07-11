package com.ecommerce.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class Mensaje {
    private String codigo;
    private  String descripcion;
}
