package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "TB_REGISTRO")
public class RegistroModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false, updatable = false)
    private Date Fecha;
    @Column(name = "DIRECCION_IP", nullable = false, updatable = false)
    private String DireccionIP;
    @Column(name = "HAWA", nullable = false, updatable = false)
    private Long Hawa;
    @Column(name = "SUCURSAL", nullable = false, updatable = false)
    private Long Sucursal;
    @Column(name = "CLIENTE", nullable = false, updatable = false)
    private Long Cliente;
    @Column(name = "VENDEDOR", nullable = false, updatable = false)
    private Long Vendedor;
    @Column(name = "TOTAL", nullable = false, updatable = false)
    private BigDecimal Total;

    public RegistroModel(Date Fecha, String DireccionIP, Long Hawa, Long Sucursal, Long Cliente, Long Vendedor, BigDecimal Total){
        this.Fecha = Fecha;
        this.DireccionIP = DireccionIP;
        this.Hawa = Hawa;
        this.Sucursal = Sucursal;
        this.Cliente = Cliente;
        this.Vendedor = Vendedor;
        this.Total = Total;
    }

    public RegistroModel(){}
}
