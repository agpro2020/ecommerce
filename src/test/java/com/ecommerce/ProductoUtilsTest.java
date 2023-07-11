//package com.ecommerce;
//
//import com.ecommerce.entity.Producto;
//import com.ecommerce.model.ProductoModel;
//import com.ecommerce.repository.DetallesRepository;
//import com.ecommerce.repository.ProductoRepository;
//import com.ecommerce.util.ProductoUtils;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.when;
//
//public class ProductoUtilsTest {
//
//    private ProductoUtils productoUtils;
//
//    @Mock
//    private ProductoRepository productoRepository;
//
//    @Mock
//    DetallesRepository detallesRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//        productoUtils = new ProductoUtils(productoRepository,detallesRepository);
//    }
//
//    @Test
//    public void testMapToProducto() {
//        // Preparar datos de prueba
//        ProductoModel productoModel = new ProductoModel();
//        productoModel.setNombre("Producto de prueba");
//        productoModel.setPrecio(10.0);
//        productoModel.setGarantia("2021");
//        productoModel.setDisponiblidad(true);
//
//        // Simular el comportamiento del repositorio
//        Producto productoEntity = new Producto();
//        when(productoRepository.save(productoEntity)).thenReturn(productoEntity);
//
//        // Ejecutar el método a probar
//        Producto productoPrincipalCreado = productoUtils.mapToProducto(productoModel);
//
//        // Verificar el resultado esperado
//        Assertions.assertEquals("Producto de prueba", productoPrincipalCreado.getNombre());
//        Assertions.assertEquals(10.0, productoPrincipalCreado.getPrecio(), 0.01);
//        Assertions.assertFalse(productoPrincipalCreado.isDisponiblidad());
//        Assertions.assertEquals("2021", productoPrincipalCreado.getGarantia());
//    }
//
//    @Test
//    public void testIsValidNombre() {
//        // Caso de prueba: nombre válido
//        boolean isValid = productoUtils.isValidNombre("Nombre válido");
//        Assertions.assertTrue(isValid);
//
//        // Caso de prueba: nombre nulo
//        isValid = productoUtils.isValidNombre(null);
//        Assertions.assertFalse(isValid);
//
//        // Caso de prueba: nombre vacío
//        isValid = productoUtils.isValidNombre("");
//        Assertions.assertFalse(isValid);
//    }
//}
