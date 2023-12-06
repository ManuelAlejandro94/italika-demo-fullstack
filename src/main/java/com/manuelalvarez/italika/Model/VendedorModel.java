package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_VENDEDOR")
public class VendedorModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "SUCURSAL")
    private Long sucursal;
}
