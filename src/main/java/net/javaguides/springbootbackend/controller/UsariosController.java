package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.exception.ResourcesNotFoundException;
import net.javaguides.springbootbackend.model.DataRequest;
import net.javaguides.springbootbackend.model.Usuario;
import net.javaguides.springbootbackend.repository.UsuarioREp;
import net.javaguides.springbootbackend.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/v1/zeus_plus_log")


public class UsariosController {
    @Autowired
    private UsuarioREp usuariosrepository;

    @GetMapping
    private List<Usuario> getAllUsuario() {
        return usuariosrepository.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuariosrepository.save(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Double id) {
        Usuario usuario = usuariosrepository.findById(id).
                orElseThrow(() -> new ResourcesNotFoundException("Usuario not exist with id" + id));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable double id, @RequestBody Usuario usuarioDetails){
        Usuario updateUsuario=usuariosrepository.findById(id)
                .orElseThrow(()->new  ResourcesNotFoundException("Usuario not exist with id:"+id));

        updateUsuario.setPagina(usuarioDetails.getPagina());
        updateUsuario.setEvento(usuarioDetails.getEvento());
        updateUsuario.setCriterio(usuarioDetails.getCriterio());
        updateUsuario.setResultado(usuarioDetails.getResultado());
        updateUsuario.setDetalle(usuarioDetails.getDetalle());
        updateUsuario.setUsuario(usuarioDetails.getUsuario());
        updateUsuario.setIp(usuarioDetails.getIp());
        updateUsuario.setFecha(usuarioDetails.getFecha());
        usuariosrepository.save(updateUsuario)   ;
        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>deleteUsuario(@PathVariable double id) {
        Usuario usuario = usuariosrepository.findById(id)
                .orElseThrow(()->new ResourcesNotFoundException("Usuario not exist with id"+id));
        usuariosrepository.delete(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("Ingresando a Test");
        Usuario usuario = new Usuario();
        usuario.setPagina("cust-inf");
        usuario.setEvento("search");
        usuario.setCriterio("x-185");
        usuario.setResultado("ok");
        usuario.setDetalle("no tiene formato valido");
        usuario.setUsuario("erick.gutierrez");
        usuario.setIp("127.0.0.3");
        usuario.setFecha(Timestamp.valueOf("2022-12-22 15:28:21"));

        return ResponseEntity.ok(usuario);
    }

//    @GetMapping("{usuario}/{ip}/{pagina}/{evento}/{feachaInicial}/{fechaFinal}/")
//    public ResponseEntity<Usuario> getLog(@PathVariable String usuario, @PathVariable String ip, @PathVariable String pagina, @PathVariable String evento, @PathVariable String fechaInicial, @PathVariable String fechaFinal  ) {
//
//        return ResponseEntity.ok();
//    }

        @PostMapping("filter")
    public ResponseEntity<?> filter(@RequestBody DataRequest dataRequest) {
            System.out.println("Ingresando Filter: "+dataRequest);
            //List<Usuario> list = usuariosrepository.filterData(dataRequest.getUsuario(), dataRequest.getIp());
            //List<Usuario> list = usuariosrepository.halfFilterData(dataRequest.getUsuario(), dataRequest.getIp(),dataRequest.getPagina(), dataRequest.getEvento());
            List<Usuario> list = usuariosrepository.fullFilterData(dataRequest.getUsuario(), dataRequest.getIp(),dataRequest.getPagina(), dataRequest.getEvento(),dataRequest.getFechaInicio(), dataRequest.getFechaFinal());
            return new ResponseEntity<>(list, HttpStatus.OK);
    }

}












/*

public class UsariosController {
    @Autowired
    private UsuarioREp usuariosrepository;

    @GetMapping
    private List<Usuario> getAllUsuario() {
        return usuariosrepository.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuariosrepository.save(usuario);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Long id) {
        Usuario usuario = usuariosrepository.findById(id).
                orElseThrow(() -> new ResourcesNotFoundException("Usuario not exist with id" + id));
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable long id, @RequestBody Usuario usuarioDetails){
        Usuario updateUsuario=usuariosrepository.findById(id)
                .orElseThrow(()->new  ResourcesNotFoundException("Usuario not exist with id:"+id));

                updateUsuario.setNombre(usuarioDetails.getNombre());
                updateUsuario.setApellido(usuarioDetails.getApellido());
                updateUsuario.setEmail(usuarioDetails.getEmail());
                updateUsuario.setTelfono(usuarioDetails.getTelfono());
                updateUsuario.setUsuario(usuarioDetails.getUsuario());
                updateUsuario.setClave(usuarioDetails.getClave());
                usuariosrepository.save(updateUsuario)   ;
                return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>deleteUsuario(@PathVariable long id) {
        Usuario usuario = usuariosrepository.findById(id)
                .orElseThrow(()->new ResourcesNotFoundException("Usuario not exist with id"+id));
        usuariosrepository.delete(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("Ingresando a Test");
        Usuario usuario = new Usuario();
        usuario.setNombre("Erick");
        usuario.setApellido("Gutierrez");
        usuario.setEmail("erick.gugo@gmail.com");
        usuario.setNombre("Erick");
        usuario.setApellido("Gutierrez");
        usuario.setEmail("erick.gugo@gmail.com");

        return ResponseEntity.ok(usuario);
    }


}*/
