package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.InventarioModel;
import com.manuelalvarez.italika.Repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Inventario")
@CrossOrigin(origins = "*")
public class InventarioRestController {

    @Autowired
    InventarioRepository inventarioRepository;

    @GetMapping(path = "/AllInventario", produces = "application/json")
    public List<InventarioModel> GetInventario(){
        return inventarioRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public InventarioModel GetById(@RequestParam("id") Long id){
        InventarioModel model = inventarioRepository.FindById(id);
        return  model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public InventarioModel AddInventario(@RequestBody InventarioModel inventarioModel){
        InventarioModel model = inventarioRepository.save(inventarioModel);
        return model;
    }

    @PutMapping(path = "/RestarInventario", consumes = "application/json", produces = "application/json")
    public InventarioModel RestarInventario(@RequestParam("id") Long id, @RequestBody InventarioModel inventarioModel){
        inventarioModel = inventarioRepository.FindById(id);
        inventarioModel.setCantidad(inventarioModel.getCantidad()-1);
        InventarioModel newModel = inventarioRepository.save(inventarioModel);
        return newModel;
    }
}
