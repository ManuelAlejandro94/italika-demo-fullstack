package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.ProductoModel;
import com.manuelalvarez.italika.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Producto")
@CrossOrigin(origins = "*")
public class ProductoRestController {

    @Autowired
    ProductoRepository productoRepository;

    @GetMapping(path = "/AllProductos", produces = "application/json")
    public List<ProductoModel> GetAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public ProductoModel GetById(@RequestParam("id") Long id){
        ProductoModel model = productoRepository.FindById(id);
        return  model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public ProductoModel AddProducto(@RequestBody ProductoModel productoModel){
        ProductoModel model = productoRepository.save(productoModel);
        return model;
    }
}
