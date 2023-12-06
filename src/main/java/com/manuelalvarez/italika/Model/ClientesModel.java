package com.manuelalvarez.italika.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "TB_CLIENTES")
public class ClientesModel {
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRES", nullable = false, updatable = false)
    private String Nombres;
    @Column(name = "APELLIDOS", nullable = false, updatable = false)
    private String Apellidos;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO", nullable = false, updatable = false)
    private Date Nacimiento;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CLIENTE", referencedColumnName = "ID")
//    List<RegistroModel> registros = new ArrayList<>();
}
