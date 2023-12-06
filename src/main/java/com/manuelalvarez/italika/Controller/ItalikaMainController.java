package com.manuelalvarez.italika.Controller;

import com.manuelalvarez.italika.Model.ProductoModel;
import com.manuelalvarez.italika.Model.RequestToken.ResponseToken;
import com.manuelalvarez.italika.ModelView.IndexViewModel;
import com.manuelalvarez.italika.Service.HttpConnectionService;
import com.manuelalvarez.italika.Service.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItalikaMainController {
    @Autowired
    HttpConnectionService httpConnectionService;
    @Autowired
    RestClient restClient;

    @RequestMapping(value = "/web", method = RequestMethod.GET)
    public String index(Model model){
        ResponseEntity<ResponseToken> responseToken = restClient.CallToken();
        String token = responseToken.getBody().getJwt();

        ResponseEntity<ProductoModel[]> responseAllProducts = restClient.CallProductos(token);
        ProductoModel[] productoModels = responseAllProducts.getBody();

        IndexViewModel modelview = new IndexViewModel();
        model.addAttribute("productos",productoModels);
        model.addAttribute("indexViewModel", modelview);
        model.addAttribute("title", "Listado");
        model.addAttribute("token", token);

        return "index";
    }

    @RequestMapping(value = "/web", method = RequestMethod.POST)
    public String Producto(@ModelAttribute IndexViewModel indexViewModel, RedirectAttributes redirectAttributes, Model model){
        redirectAttributes.addFlashAttribute("indexViewModel", indexViewModel);
        return "redirect:/web/producto";
    }
}
