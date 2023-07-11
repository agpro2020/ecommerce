package com.ecommerce.util;


import com.ecommerce.responses.Mensaje;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespuestaProducto  {
    String descripcion,codigo; //---->Variables para los resultados OK
    protected List<Mensaje> mensajes; //Lista de mensajes para los posibles fallos
    public RespuestaProducto( List<Mensaje> list){
        this.mensajes = list;
    }
    public RespuestaProducto (String codigo,String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    }
}