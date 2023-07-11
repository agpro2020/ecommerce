package com.ecommerce.responses;

import com.ecommerce.responses.Mensaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class CustomException extends Exception{
    protected List<Mensaje> mensajes;
    public CustomException(){
        mensajes = new ArrayList<>();
    }
    public void añadirMensaje(Mensaje m){
        this.mensajes.add(m);

    }

}

/*La clase custom lo que hace es evaluar si
* algun error  y lo añade a la lista creada.
11--> crear una lista.
12--> constructor sin parametros para iniciar el array
    y que nunca este vacio, aunque no haya errores.
15--> metado para añadir mensajes a la lista,
es decir cada vez que hay un error lo mete ,
es un metado que no devuelve nada, y por parametro se
le pasa la clase Mensaje para asi añadir al mensaje
el codigo y la descripcion.

* */