package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TB_SUCURSAL")
public class SucursalModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SUCURSAL", nullable = false, updatable = false)
    private String sucursal;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "SUCURSAL", referencedColumnName = "ID")
//    List<VendedorModel> vendedores = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "SUCURSAL", referencedColumnName = "ID")
//    List<VendedorModel> registros = new ArrayList<>();
}
