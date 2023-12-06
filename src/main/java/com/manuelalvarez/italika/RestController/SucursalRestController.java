package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.SucursalModel;
import com.manuelalvarez.italika.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/Sucursales")
@CrossOrigin(origins = "*")
public class SucursalRestController {

    @Autowired
    SucursalRepository sucursalRepository;

    @GetMapping(path = "/AllSucursales", produces = "application/json")
    public List<SucursalModel> GetAllSucursales(){
        return sucursalRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public SucursalModel GetById(@RequestParam("id") Long id){
        SucursalModel model = sucursalRepository.FindById(id);
        return model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public SucursalModel AddSucursal(@RequestBody SucursalModel sucursalModel){
        SucursalModel model = sucursalRepository.save(sucursalModel);
        return model;
    }

    @GetMapping(path = "/RandomSucursal", produces = "application/json")
    public Long RandomSucursal(){

        Long id = 0L;
        Random  rand = new Random();
        Boolean b = rand.nextBoolean();
        if(b){
            id = 1L;
        }
        else {
            id = 2L;
        }
        return id;
    }
}
