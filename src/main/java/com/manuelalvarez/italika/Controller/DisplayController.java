package com.manuelalvarez.italika.Controller;

import com.manuelalvarez.italika.Model.*;
import com.manuelalvarez.italika.Model.RequestToken.ResponseToken;
import com.manuelalvarez.italika.ModelView.RegistroDetailsViewModel;
import com.manuelalvarez.italika.Service.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class DisplayController {
    @Autowired
    RestClient restClient;

    @RequestMapping(value = "/web/display", method = RequestMethod.GET)
    public String DisplayAll(Model model){
        ResponseEntity<ResponseToken> responseToken = restClient.CallToken();
        String token = responseToken.getBody().getJwt();

        ResponseEntity<RegistroModel[]> registroModelResponseEntity = restClient.CallRegistros(token);
        RegistroModel[] registroModel = registroModelResponseEntity.getBody();

        RegistroDetailsViewModel registroDetailsViewModel = new RegistroDetailsViewModel();

        model.addAttribute("registroModel", registroModel);
        model.addAttribute("token", token);
        model.addAttribute("registroDetailsViewModel", registroDetailsViewModel);

        return "/display/display";
    }

    @RequestMapping(value = "/web/display", method = RequestMethod.POST)
    public String DisplayDetails(@ModelAttribute RegistroDetailsViewModel registroDetailsViewModel, RedirectAttributes redirectAttributes, Model model){
        redirectAttributes.addFlashAttribute("registroDetailsViewModel", registroDetailsViewModel);
        return "redirect:/web/display/details";
    }

    @RequestMapping(value = "/web/display/details", method = RequestMethod.GET)
    public String DisplayExtendDetails(HttpServletRequest request, Model model){
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        RegistroDetailsViewModel registroDetailsViewModel = (RegistroDetailsViewModel) flashMap.get("registroDetailsViewModel");
        RegistroModel registroModel = new RegistroModel();
        registroModel.setId(registroDetailsViewModel.getId());
        registroModel.setVendedor(registroDetailsViewModel.getVendedor());
        registroModel.setTotal(registroDetailsViewModel.getTotal());
        registroModel.setSucursal(registroDetailsViewModel.getSucursal());
        registroModel.setHawa(registroDetailsViewModel.getHawa());
        registroModel.setFecha(registroDetailsViewModel.getFecha());
        registroModel.setDireccionIP(registroDetailsViewModel.getDireccionIP());
        registroModel.setCliente(registroDetailsViewModel.getCliente());

        ResponseEntity<VendedorModel> vendedorModelResponseEntity = restClient.CallVendedorById(registroDetailsViewModel.getToken(), registroModel.getVendedor());
        VendedorModel vendedorModel = vendedorModelResponseEntity.getBody();
        ResponseEntity<SucursalModel> sucursalModelResponseEntity = restClient.CallSucursalById(registroDetailsViewModel.getToken(), registroModel.getSucursal());
        SucursalModel sucursalModel = sucursalModelResponseEntity.getBody();
        ResponseEntity<ProductoModel> productoModelResponseEntity = restClient.CallProductoById(registroDetailsViewModel.getToken(), registroModel.getHawa());
        ProductoModel productoModel = productoModelResponseEntity.getBody();
        ResponseEntity<ClientesModel> clientesModelResponseEntity = restClient.CallClienteById(registroDetailsViewModel.getToken(), registroModel.getCliente());
        ClientesModel clientesModel = clientesModelResponseEntity.getBody();

        model.addAttribute("registroModel", registroModel);
        model.addAttribute("vendedorModel", vendedorModel);
        model.addAttribute("sucursalModel", sucursalModel);
        model.addAttribute("productoModel", productoModel);
        model.addAttribute("clientesModel", clientesModel);

        return "/display/displaydetails";
    }
}
