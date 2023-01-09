package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface UsuarioREp extends JpaRepository<Usuario, Double> {

//    @Query(value = "SELECT * FROM zeus_plus_log u where u.pagina like %?1% and u.evento like %?1% and u.usuario like %?1% and u.ip like %?1%  and u.fecha between Cast(like %?1% AS DATE) and Cast(like %?1% AS DATE)", nativeQuery = true)
//    List<ProyectoFinalBean> select(String input);

    @Query(value = "SELECT * FROM zeus_plus_log u where u.usuario like %?1% and u.ip like %?2% and u.pagina like %?3% and u.evento like %?4%", nativeQuery = true)
    List<Usuario> halfFilterData(String usuario, String ip, String pagina, String evento);

    @Query(value = "SELECT * FROM zeus_plus_log u where u.usuario like %?1% and u.ip like %?2% and u.pagina like %?3% and u.evento like %?4% and u.fecha between ?5 and ?6", nativeQuery = true)
    List<Usuario> fullFilterData(String usuario, String ip, String pagina, String evento, Date fechaInicio,Date fechaFinal);

    @Query(value = "SELECT * FROM zeus_plus_log u where u.usuario like %?1% and u.ip like %?2%", nativeQuery = true)
    List<Usuario> filterData(String usuario, String ip);
}
