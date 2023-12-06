package com.manuelalvarez.italika.Controller;

import com.manuelalvarez.italika.Model.InventarioModel;
import com.manuelalvarez.italika.Model.ProductoModel;
import com.manuelalvarez.italika.Model.SucursalModel;
import com.manuelalvarez.italika.ModelView.IndexViewModel;
import com.manuelalvarez.italika.ModelView.RegistroViewModel;
import com.manuelalvarez.italika.Service.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ProductoController {
    @Autowired
    RestClient restClient;

    @RequestMapping(value = "/web/producto", method = RequestMethod.GET)
    public String Producto(HttpServletRequest request, Model model){
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        IndexViewModel indexViewModel = (IndexViewModel) flashMap.get("indexViewModel");

        ResponseEntity<ProductoModel> responseEntity = restClient.CallProductoById(indexViewModel.getToken(), indexViewModel.getIdProducto());
        ProductoModel productoModel = responseEntity.getBody();
        //ProductoModel productoModel = responseEntity.clone()[0];
        ResponseEntity<InventarioModel> inventarioModelResponseEntity = restClient.CallInventarioById(indexViewModel.getToken(), indexViewModel.getIdProducto());
        InventarioModel inventarioModel = inventarioModelResponseEntity.getBody();

        RegistroViewModel registroViewModel = new RegistroViewModel();
        model.addAttribute("title", "Producto");
        model.addAttribute("productoModel", productoModel);
        model.addAttribute("cantidad", inventarioModel.getCantidad());
        model.addAttribute("ip",request.getRemoteAddr());
        model.addAttribute("indexViewModel", registroViewModel);
        model.addAttribute("token", indexViewModel.getToken());
        return "producto";
    }

    @RequestMapping(value = "/web/producto", method = RequestMethod.POST)
    public String Registro(@ModelAttribute RegistroViewModel indexViewModel, RedirectAttributes redirectAttributes, Model model){
        redirectAttributes.addFlashAttribute("indexViewModel", indexViewModel);
        return "redirect:/web/registro";
    }
}
