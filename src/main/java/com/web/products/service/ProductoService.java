package com.web.products.service;

import com.web.products.model.Producto;
import com.web.products.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProducts(){
        return productoRepository.findAll();
    }

    public Producto getProduct(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto addProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto updateProduct(Producto producto){
        return productoRepository.save(producto);
    }

    public void deleteProduct(Long id){
        productoRepository.deleteById(id);
    }

}
