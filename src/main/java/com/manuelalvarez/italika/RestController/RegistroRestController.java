package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.RegistroModel;
import com.manuelalvarez.italika.Repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Registro")
@CrossOrigin(origins = "*")
public class RegistroRestController {

    @Autowired
    RegistroRepository registroRepository;

    @GetMapping(path = "/AllRegistros", produces = "application/json")
    public List<RegistroModel> GetAllRegistros(){
        return registroRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public RegistroModel GetByRegistro(@RequestParam("id") Long id){
        RegistroModel model = registroRepository.FindById(id);
        return model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public RegistroModel AddRegistro(@RequestBody RegistroModel registroModel){
        RegistroModel model = registroRepository.save(registroModel);
        return model;
    }

    //Api que regresa lo visual para registro completo
}
