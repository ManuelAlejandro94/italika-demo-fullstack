package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.VendedorModel;
import com.manuelalvarez.italika.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/Vendedor")
@CrossOrigin(origins = "*")
public class VendedorRestController {
    @Autowired
    VendedorRepository vendedorRepository;

    @GetMapping(path = "/AllVendedores", produces = "application/json")
    public List<VendedorModel> GetAllVendedores(){
        return  vendedorRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public VendedorModel GetById(@RequestParam("id") Long id){
        VendedorModel model = vendedorRepository.FindById(id);
        return model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public VendedorModel AddVendedor(@RequestBody VendedorModel vendedorModel){
        VendedorModel model = vendedorRepository.save(vendedorModel);
        return model;
    }

    @GetMapping(path = "/RandomVendedor", produces = "application/json")
    public Long RandomVendedor(@RequestParam("id") Long id){
        List<VendedorModel> vendedores = vendedorRepository.FindBySucursalParam(id);
        Long nid = 0L;
        Random rand = new Random();
        Boolean b = rand.nextBoolean();
        if(b){
            nid = vendedores.get(1).getId();
        }
        else {
            nid = vendedores.get(0).getId();
        }
        return nid;
    }
}
