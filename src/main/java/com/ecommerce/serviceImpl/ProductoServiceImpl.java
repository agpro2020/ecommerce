package com.ecommerce.serviceImpl;

import com.ecommerce.entity.Detalle;
import com.ecommerce.entity.Producto;
import com.ecommerce.repository.DetallesRepository;
import com.ecommerce.responses.CustomException;
import com.ecommerce.responses.Mensaje;
import com.ecommerce.model.ProductoModel;
import com.ecommerce.repository.ProductoRepository;
import com.ecommerce.service.ProductoService;
import com.ecommerce.util.ProductoUtils;
import com.ecommerce.util.RespuestaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductoServiceImpl implements ProductoService {

  @Autowired
  private ProductoRepository productoRepository;

  @Autowired
    DetallesRepository detallesRepository;

  @Autowired
  private ProductoUtils productoUtils = new ProductoUtils();

    @Override
    public ResponseEntity<RespuestaProducto> crearProducto(ProductoModel productoModel) throws CustomException {
        CustomException ex = new CustomException();

        if (!productoUtils.isValidNombre(productoModel.getNombre(),
                productoModel.getFechaCreacion(),productoModel.getColor())){
            ex.añadirMensaje(new Mensaje("30000", "Nombre incorrecto "+productoModel.getNombre()));
        }
        if (!productoUtils.isValidDetalle(
                productoModel.getFechaCreacion(),productoModel.getColor())){
            ex.añadirMensaje(new Mensaje("30000", "Nombre incorrecto "+productoModel.getNombre()));
        }
        if (productoModel.getPrecio() <= 0){
            ex.añadirMensaje(new Mensaje("4000", "Precio inferior: "+productoModel.getPrecio()));
        }
        if (!ex.getMensajes().isEmpty()) {
            // Si se encontraron errores, devuelve la lista de mensajes en una respuesta de error
            return new ResponseEntity<>(new RespuestaProducto(ex.getMensajes()), HttpStatus.CONFLICT);
        } else {
            // Si no hay errores, se continúa con la creación del producto
            Producto productoEntity = productoUtils.mapToProducto(productoModel);
            Producto productoPrincipalCreado = productoRepository.save(productoEntity);
            Detalle detalleEntity = productoUtils.mapToDtalle(productoModel);
            detalleEntity.setProducto(productoPrincipalCreado);
            Detalle detalleCreado = detallesRepository.save(detalleEntity);
            // Se devuelve una respuesta exitosa
            //return new ResponseEntity<>(HttpStatus.OK);
            return new ResponseEntity<>(new RespuestaProducto("0000","Datos Procesados correctamente"), HttpStatus.OK);
        }
    }





}