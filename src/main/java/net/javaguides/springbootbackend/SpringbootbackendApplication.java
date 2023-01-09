package net.javaguides.springbootbackend;


import net.javaguides.springbootbackend.model.Usuario;
import net.javaguides.springbootbackend.repository.UsuarioREp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class SpringbootbackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbackendApplication.class, args);
	}

	@Autowired
	private UsuarioREp usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario=new Usuario();
		usuario.setPagina("cust-inf");
		usuario.setEvento("search");
		usuario.setCriterio("x-185");
		usuario.setResultado("ok");
		usuario.setDetalle("no tiene formato valido");
		usuario.setUsuario("erick.gutierrez");
		usuario.setIp("127.0.0.2");
		usuario.setFecha(Timestamp.valueOf("2022-09-22 19:38:21"));

		usuarioRepository.save(usuario);

		Usuario usuario1=new Usuario();
		usuario1.setPagina("cust-inf");
		usuario1.setEvento("search");
		usuario1.setCriterio("x-285");
		usuario1.setResultado("error");
		usuario1.setDetalle("no tiene formato valido");
		usuario1.setUsuario("andre.crespo");
		usuario1.setIp("127.0.0.1");
		usuario1.setFecha(Timestamp.valueOf("2022-10-22 13:28:28"));
		usuarioRepository.save(usuario1);
	}
}

	/*
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario=new Usuario();
		usuario.setNombre("Andre");
		usuario.setApellido("Crespo");
		usuario.setEmail("andrecr6600@gmali.com");
		usuario.setTelfono("7715121");
		usuario.setUsuario("ACrespo");
		usuario.setClave("andrecr6600@gmali.com");
		usuarioRepository.save(usuario);

		Usuario usuario1=new Usuario();
		usuario1.setNombre("Erick");
		usuario1.setApellido("Gutierrez");
		usuario1.setEmail("erickgugo@gmali.com");
		usuario1.setTelfono("7788893");
		usuario1.setUsuario("egugo");
		usuario1.setClave("erickgugo@gmali.com");
		usuarioRepository.save(usuario1);
	}
}

	 */



