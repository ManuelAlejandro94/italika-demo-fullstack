package com.manuelalvarez.italika.Controller;

import com.manuelalvarez.italika.Model.*;
import com.manuelalvarez.italika.ModelView.LastRegistroViewModel;
import com.manuelalvarez.italika.ModelView.RegistroViewModel;
import com.manuelalvarez.italika.Service.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class RegistoController {
    @Autowired
    RestClient restClient;

    @RequestMapping(value = "/web/registro", method = RequestMethod.GET)
    public String Registro(HttpServletRequest request, Model model){
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        RegistroViewModel registroViewModel = (RegistroViewModel) flashMap.get("indexViewModel");

        ResponseEntity<Long> idSucursalRequest = restClient.CallSucursalRandom(registroViewModel.getToken());
        Long idSucursal = idSucursalRequest.getBody();
        ResponseEntity<SucursalModel> sucursalModelResponseEntity = restClient.CallSucursalById(registroViewModel.getToken(), idSucursal);
        SucursalModel sucursalModel = sucursalModelResponseEntity.getBody();
        ResponseEntity<Long> longResponseEntity = restClient.CallVendedorRandom(registroViewModel.getToken(), sucursalModel.getId());
        ResponseEntity<VendedorModel> vendedorModelResponseEntity = restClient.CallVendedorById(registroViewModel.getToken(), longResponseEntity.getBody());
        VendedorModel vendedorModel = vendedorModelResponseEntity.getBody();
        ResponseEntity<ProductoModel> responseEntity = restClient.CallProductoById(registroViewModel.getToken(), registroViewModel.getIdHawa());
        ProductoModel productoModel = responseEntity.getBody();
        LastRegistroViewModel lastRegistroViewModel = new LastRegistroViewModel();
        ResponseEntity<ClientesModel> clientesModelResponseEntity = restClient.CallClienteById(registroViewModel.getToken(), 1L);
        ClientesModel clientesModel = clientesModelResponseEntity.getBody();

        model.addAttribute("viewModel", registroViewModel);
        model.addAttribute("sucursalModel", sucursalModel);
        model.addAttribute("vendedorModel", vendedorModel);
        model.addAttribute("productoModel", productoModel);
        model.addAttribute("lastRegistroViewModel", lastRegistroViewModel);
        model.addAttribute("clientesModel", clientesModel);
        return "registro";
    }

    @RequestMapping(value = "/web/registro", method = RequestMethod.POST)
    public String AddRegistro(@ModelAttribute LastRegistroViewModel lastRegistroViewModel, Model model){
        RegistroModel registroModel = new RegistroModel();
        registroModel.setCliente(lastRegistroViewModel.getCliente());
        registroModel.setDireccionIP(lastRegistroViewModel.getIp());
        registroModel.setFecha(new Date(System.currentTimeMillis()));
        registroModel.setHawa(lastRegistroViewModel.getIdHawa());
        registroModel.setSucursal(lastRegistroViewModel.getSucursal());
        registroModel.setTotal(lastRegistroViewModel.getTotal());
        registroModel.setVendedor(lastRegistroViewModel.getVendedor());
        ResponseEntity<RegistroModel> registroModelResponseEntity = restClient.CallRegistroNuevo(lastRegistroViewModel.getToken(),registroModel);
        RegistroModel registroModel1 = registroModelResponseEntity.getBody();
        //Llamar put actualiza registro
        ResponseEntity<InventarioModel> inventarioModelResponseEntity = restClient.CallInventarioRestar(lastRegistroViewModel.getToken(), registroModel1.getHawa());
        InventarioModel inventarioModel = inventarioModelResponseEntity.getBody();
        return "redirect:/web/result";
    }
}
