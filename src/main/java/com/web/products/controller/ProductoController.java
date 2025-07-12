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
    public Producto getProduct(@PathVariable("id") Long id){
        return productoService.getProduct(id);
    }

    @PutMapping("/product/{id}")
    @CrossOrigin
    public Producto updateProduct(@RequestBody() Producto producto, @PathVariable("id") Long id){
        return productoService.updateProduct(producto);
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
