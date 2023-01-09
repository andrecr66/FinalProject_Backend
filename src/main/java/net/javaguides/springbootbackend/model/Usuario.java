package net.javaguides.springbootbackend.model;

import lombok.*;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="zeus_plus_log")

public class Usuario {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private double id;

    @Column(name="PAGINA")
    private String pagina;

    @Column(name="EVENTO")
    private String evento;

    @Column(name="CRITERIO")
    private String criterio;

    @Column(name="RESULTADO")
    private String resultado;

    @Column(name="DETALLE")
    private String detalle;

    @Column(name="USUARIO")
    private String usuario;

    @Column(name="IP")
    private String ip;

    @Column(name="FECHA")
    private Timestamp fecha;



}


/*
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="telfono")
    private String telfono;

    @Column(name="email")
    private String email;

    @Column(name="usuario")
    private String usuario;

    @Column(name="clave")
    private String clave;



}
*/
