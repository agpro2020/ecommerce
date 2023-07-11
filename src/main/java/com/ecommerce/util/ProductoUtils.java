package com.ecommerce.util;

import com.ecommerce.entity.Detalle;
import com.ecommerce.entity.Producto;
import com.ecommerce.model.ProductoModel;
import com.ecommerce.repository.DetallesRepository;
import com.ecommerce.repository.ProductoRepository;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Component
public class ProductoUtils {

    public  ProductoUtils (){

    }
    public ProductoUtils(ProductoRepository productoRepository, DetallesRepository detallesRepository) {
    }

    public Producto mapToProducto(ProductoModel productoModel) {
        Producto productoEntity = new Producto();
         productoEntity.setNombre(productoModel.getNombre());
         productoEntity.setPrecio(productoModel.getPrecio());
         productoEntity.setDisponiblidad(false);
         productoEntity.setGarantia(productoModel.getGarantia());
        return productoEntity;
        /*Lo que hago en este metado es*/
    }

    //DETALLE
    public Detalle mapToDtalle(ProductoModel productoModel) {
        Detalle detalleEntity = new Detalle();
        detalleEntity.setColor(productoModel.getColor());
        detalleEntity.setNuevo(productoModel.isNuevo());
        detalleEntity.setFechaCreacion(productoModel.getFechaCreacion());
        return detalleEntity;
        /*Lo que hago en este metado es*/
    }


    public boolean isValidNombre(String nombre, Date fechaCreacion,String color) {
        // Lógica de validación para el campo "nombre"
        // Puedes implementar tus propias reglas de validación aquí
        if (nombre == null || nombre.isEmpty()) {
            return false;
        }
        if (fechaCreacion == null) {
            return false;
        }
        if (color == null || color.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isValidDetalle(Date fechaCreacion,String color) {
        // Lógica de validación para el campo "nombre"
        // Puedes implementar tus propias reglas de validación aquí
        if (fechaCreacion == null) {
            return false;
        }
        if (color == null || color.isEmpty()) {
            return false;
        }
        return true;
    }

}
