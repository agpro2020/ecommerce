package com.ecommerce.controller;


import com.ecommerce.responses.CustomException;
import com.ecommerce.model.ProductoModel;
import com.ecommerce.service.ProductoService;
import com.ecommerce.util.RespuestaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class MiController {
    @Autowired
    private ProductoService productoService;


    @PostMapping("/producto")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<RespuestaProducto> productoCrear(@RequestBody @Valid ProductoModel productoModel) throws CustomException {
        return productoService.crearProducto(productoModel );
    }

}
