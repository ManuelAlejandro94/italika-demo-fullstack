package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_INVENTARIO")
public class InventarioModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CANTIDAD", nullable = false, updatable = true)
    private Long Cantidad;
    @Column(name = "ID_PRODUCTO", nullable = false, updatable = false)
    private Long IdProducto;
}
