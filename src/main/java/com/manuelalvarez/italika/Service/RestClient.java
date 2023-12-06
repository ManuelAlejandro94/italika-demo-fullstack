package com.manuelalvarez.italika.Service;

import com.manuelalvarez.italika.Model.*;
import com.manuelalvarez.italika.Model.RequestToken.AuthenticationRequest;
import com.manuelalvarez.italika.Model.RequestToken.AuthenticationsResponse;
import com.manuelalvarez.italika.Model.RequestToken.ResponseToken;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestClient {

    private static final String POST_TOKEN = "http://localhost:50014/api/Authentication";
    private static final String GET_PRODUCTOS = "http://localhost:50014/api/Producto/AllProductos";
    private static final String GET_PRODUCTOBYID = "http://localhost:50014/api/Producto/GetById";
    private static final String GET_INVENTARIOBYID = "http://localhost:50014/api/Inventario/GetById/";
    private static final String GET_SUCURSALES = "http://localhost:50014/api/Sucursales/AllSucursales";
    private static final String GET_SUCURSALESBYID = "http://localhost:50014/api/Sucursales/GetById";
    private static final String GET_SUCURSALESRANDOMSUC = "http://localhost:50014/api/Sucursales/RandomSucursal";
    private static final String GET_VENDEDORRANDOM = "http://localhost:50014/api/Vendedor/RandomVendedor";
    private static final String GET_VENDEDORBYID = "http://localhost:50014/api/Vendedor/GetById";
    private static final String GET_CLIENTEBYID = "http://localhost:50014/api/Clientes/GetById";
    private static final String GET_REGISTROCREATED = "http://localhost:50014/api/Registro/Add";
    private static final String GET_INVENTARIORESTAR = "http://localhost:50014/api/Inventario/RestarInventario?id=";
    private static final String GET_REGISTROS = "http://localhost:50014/api/Registro/AllRegistros";
    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<ResponseToken> CallToken(){
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("apiuseradmin", "Ap1p@$$w0rd@dm1n");
        ResponseEntity<ResponseToken> responseEntity = restTemplate.postForEntity(POST_TOKEN, authenticationRequest, ResponseToken.class);
        return responseEntity;
    }

    public ResponseEntity<ProductoModel[]> CallProductos(String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<ProductoModel[]> responseEntity = restTemplate.exchange(GET_PRODUCTOS, HttpMethod.GET, entity, ProductoModel[].class);
        return responseEntity;
    }

    public ResponseEntity<ProductoModel> CallProductoById(String token, Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_PRODUCTOBYID)
                .queryParam("id", id);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<ProductoModel> productoModel = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ProductoModel.class);

        return productoModel;
    }

    public ResponseEntity<InventarioModel> CallInventarioById(String token, Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_INVENTARIOBYID)
                .queryParam("id", id);
        HttpEntity<String> entity = new HttpEntity(httpHeaders);

        ResponseEntity<InventarioModel> productoModel = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, InventarioModel.class);

        return productoModel;
    }

    public ResponseEntity<SucursalModel[]> CallSucursales(String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<SucursalModel[]> responseEntity = restTemplate.exchange(GET_SUCURSALES, HttpMethod.GET, entity, SucursalModel[].class);
        return responseEntity;
    }

    public ResponseEntity<Long> CallSucursalRandom(String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_SUCURSALESRANDOMSUC);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);

        return responseEntity;
    }

    public ResponseEntity<SucursalModel> CallSucursalById(String token, Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_SUCURSALESBYID)
                .queryParam("id", id);
        HttpEntity<String> entity = new HttpEntity(httpHeaders);

        ResponseEntity<SucursalModel> entityResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, SucursalModel.class);

        return entityResponse;
    }

    public ResponseEntity<Long> CallVendedorRandom(String token, Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_VENDEDORRANDOM)
                .queryParam("id", id);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Long.class);

        return responseEntity;
    }

    public ResponseEntity<VendedorModel> CallVendedorById(String token, Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_VENDEDORBYID)
                .queryParam("id", id);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<VendedorModel> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, VendedorModel.class);

        return responseEntity;
    }

    public ResponseEntity<ClientesModel> CallClienteById(String token, Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_CLIENTEBYID)
                .queryParam("id", id);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<ClientesModel> clientesModel = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ClientesModel.class);

        return clientesModel;
    }

    public ResponseEntity<RegistroModel> CallRegistroNuevo(String token, RegistroModel _registroModel){
        String newstring = new SimpleDateFormat("yyyy-MM-dd").format(_registroModel.getFecha());

        RegistroModel registroModel = new RegistroModel(_registroModel.getFecha(),
                _registroModel.getDireccionIP(), _registroModel.getHawa(), _registroModel.getSucursal(),
                _registroModel.getCliente(), _registroModel.getVendedor(), _registroModel.getTotal());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+token);

        HttpEntity<RegistroModel> request = new HttpEntity<>(registroModel, headers);
        ResponseEntity<RegistroModel> responseEntity = restTemplate.postForEntity(GET_REGISTROCREATED, request, RegistroModel.class);
        return responseEntity;
    }

    public ResponseEntity<InventarioModel> CallInventarioRestar(String token, Long id){

        InventarioModel inventarioModel = new InventarioModel();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(GET_INVENTARIORESTAR+id)
                .queryParam("id", 0L)
                .queryParam("cantidad", 0L)
                .queryParam("idproducto", 0L);
        HttpEntity<InventarioModel> entity = new HttpEntity<InventarioModel>(inventarioModel, httpHeaders);

        ResponseEntity<InventarioModel> entityResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, entity, InventarioModel.class);

        return entityResponse;
    }

    public ResponseEntity<RegistroModel[]> CallRegistros(String token){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.add("Authorization", "Bearer "+token);

        HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);
        ResponseEntity<RegistroModel[]> responseEntity = restTemplate.exchange(GET_REGISTROS, HttpMethod.GET, entity, RegistroModel[].class);
        return responseEntity;
    }
}
