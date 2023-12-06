package com.manuelalvarez.italika.Controller;

import com.manuelalvarez.italika.Service.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {
    @Autowired
    RestClient restClient;

    @RequestMapping(value = "/web/result", method = RequestMethod.GET)
    public String Result(Model model){
        model.addAttribute("title", "Exito");
        return "result";
    }
}
