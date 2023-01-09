package net.javaguides.springbootbackend.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class DataRequest {
    private String usuario;
    private String ip;
    private String pagina;
    private String evento;
    private Date fechaInicio;
    private Date fechaFinal;
    //private Timestamp fechaInicio;
    //private Timestamp fechaFinal;
}
