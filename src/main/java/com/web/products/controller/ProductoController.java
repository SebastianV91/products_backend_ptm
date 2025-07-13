package com.web.products.controller;

import com.web.products.model.Producto;
import com.web.products.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    private ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/products")
    @CrossOrigin
    public List<Producto> getProducts(){
        return productoService.getProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Producto> getProduct(@PathVariable("id") Long id){
        return productoService.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/product/{id}")
    @CrossOrigin
    public ResponseEntity<Producto> updateProduct(@PathVariable("id") Long id, @RequestBody() Producto producto){
        return productoService.getProduct(id)
                .map(pExistente -> {
                    producto.setId(id);
                    return ResponseEntity.ok(productoService.addProduct(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    @CrossOrigin
    public ResponseEntity<Producto> addNew(@RequestBody() Producto producto){
        Producto newProduct = productoService.addProduct(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @DeleteMapping("/product/{id}")
    @CrossOrigin
    public void deleteProduct(@PathVariable("id") Long id){
        productoService.deleteProduct(id);
    }

}
