package com.manuelalvarez.italika.RestController;

import com.manuelalvarez.italika.Model.UsersModel;
import com.manuelalvarez.italika.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Users")
@CrossOrigin(origins = "*")
public class UsersRestController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(path = "/AllUsers", produces = "application/json")
    public List<UsersModel> GetAllUsers(){
        return usersRepository.findAll();
    }

    @GetMapping(path = "/GetById", produces = "application/json")
    public UsersModel GetById(@RequestParam("id") Long id){
        UsersModel model = usersRepository.FindById(id);
        return model;
    }

    @PostMapping(path = "/Add", consumes = "application/json", produces = "application/json")
    public UsersModel AddUser(@RequestBody UsersModel usersModel){
        UsersModel model = usersRepository.save(usersModel);
        return model;
    }
}
