package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TB_PRODUCTO")
public class ProductoModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "HAWA", nullable = false, updatable = false)
    private String Hawa;
    @Column(name = "MODELO", nullable = false, updatable = false)
    private String Modelo;
    @Column(name = "PRECIO", nullable = false, updatable = false)
    private BigDecimal Precio;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID")
//    List<InventarioModel> inventarios = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "HAWA", referencedColumnName = "ID")
//    List<RegistroModel> registros = new ArrayList<>();
}
