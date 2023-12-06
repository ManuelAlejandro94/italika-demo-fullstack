package com.manuelalvarez.italika.ModelView;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class RegistroViewModel {
    private String Ip;
    private Long IdHawa;
    @Temporal(value = TemporalType.DATE)
    private Date Fecha = new Date(System.currentTimeMillis());
    private String Token;
    //private Long Sucursal;
    //private Long Vendedor;
}
