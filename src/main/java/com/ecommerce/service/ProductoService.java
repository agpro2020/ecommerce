package com.ecommerce.service;

import com.ecommerce.responses.CustomException;
import com.ecommerce.model.ProductoModel;
import com.ecommerce.util.RespuestaProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductoService {
    ResponseEntity<RespuestaProducto> crearProducto(ProductoModel ProductoModel) throws CustomException, CustomException;
}
