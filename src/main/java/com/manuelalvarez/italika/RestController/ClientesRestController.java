package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.ClientesModel;
import com.manuelalvarez.italika.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Clientes")
@CrossOrigin(origins = "*")
public class ClientesRestController {

    @Autowired
    ClientesRepository clientesRepository;

    @GetMapping(path = "/AllClientes", produces = "application/json")
    public List<ClientesModel> GetClientes(){
        return clientesRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public ClientesModel GetById(@RequestParam("id") Long id){
        ClientesModel model = clientesRepository.FindById(id);
        return model;
    }

    @GetMapping(path = "/GetPrimerCliente", produces = "application/json")
    public ClientesModel GetFirstCliente(){
        List<ClientesModel> models = clientesRepository.findAll();
        ClientesModel model = models.get(0);
        return model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public ClientesModel AddCliente(@RequestBody ClientesModel clientesModel){
        ClientesModel clienteCreated = clientesRepository.save(clientesModel);
        return clienteCreated;
    }
}
