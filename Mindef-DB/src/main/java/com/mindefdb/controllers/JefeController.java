package com.mindefdb.controllers;

import org.slf4j.LoggerFactory;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindefdb.dtos.JefeDTO;
import com.mindefdb.services.IJefeService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/jefes")
public class JefeController {
    
    @Autowired 
    private IJefeService jefeService;
    
    private Logger log = LoggerFactory.getLogger(JefeController.class.getName());
    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(@Valid @RequestBody JefeDTO jefeDTO) {
        log.debug("JefeController.insertar() ==================> INICIO <==================");
        try {
            JefeDTO retorno = jefeService.insertar(jefeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.insertar() ==================> FIN <==================");
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long idJefe) {
        log.debug("JefeController.eliminar() ==================> INICIO <==================");
        try {
            jefeService.eliminar(idJefe);
            return ResponseEntity.status(HttpStatus.OK)
                .body("Registro eliminado satisfactoriamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.eliminar() ==================> FIN <==================");
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        log.debug("JefeController.getAll() ==================> INICIO <==================");
        try {
            List<JefeDTO> listaRetorno = jefeService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(listaRetorno);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.getAll() ==================> FIN <==================");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long idJefe) {
        log.debug("JefeController.getById() ==================> INICIO <==================");
        try {
            JefeDTO objRetorno = jefeService.getById(idJefe);
            return ResponseEntity.status(HttpStatus.OK).body(objRetorno);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.getById() ==================> FIN <==================");
        }
    }
    
    @GetMapping("/hateoas/{id}")
    public ResponseEntity<?> getHateoasById(@PathVariable("id") Long idJefe) {
        log.debug("JefeController.getHateoasById() ==================> INICIO <==================");
        try {
            JefeDTO objRetorno = jefeService.getById(idJefe);
            
            EntityModel<JefeDTO> resource = EntityModel.of(objRetorno);
            
            resource.add(linkTo(methodOn(JefeController.class)
                .getHateoasById(idJefe))
                .withSelfRel());
            
            resource.add(linkTo(methodOn(JefeController.class)
                .getAll())
                .withRel("todos-los-jefes"));
            
            resource.add(linkTo(methodOn(JefeController.class)
                .update(objRetorno))
                .withRel("actualizar"));
            
            resource.add(linkTo(methodOn(JefeController.class)
                .eliminar(idJefe))
                .withRel("eliminar"));
            
            if (objRetorno.getFlagEstado().equals("1")) {
                resource.add(linkTo(methodOn(JefeController.class)
                    .desactivarJefe(objRetorno))
                    .withRel("deactivate"));
            } else {
                resource.add(linkTo(methodOn(JefeController.class)
                    .activarJefe(objRetorno))
                    .withRel("activarse"));
            }
            
            return ResponseEntity.status(HttpStatus.OK).body(resource);
            
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.getHateoasById() ==================> FIN <==================");
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody JefeDTO jefeDTO) {
        log.debug("JefeController.update() ==================> INICIO <==================");
        try {
            jefeService.update(jefeDTO);
            return ResponseEntity.status(HttpStatus.OK)
                .body("Grabación realizada correctamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.update() ==================> FIN <==================");
        }
    }
    
    @PutMapping("/desactivarJefe")
    public ResponseEntity<?> desactivarJefe(@RequestBody JefeDTO jefeDTO) {
        log.debug("JefeController.desactivarJefe() ==================> INICIO <==================");
        try {
            jefeDTO.setFlagEstado("0");
            jefeService.update(jefeDTO);
            return ResponseEntity.status(HttpStatus.OK)
                .body("Jefe desactivado correctamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.desactivarJefe() ==================> FIN <==================");
        }
    }
    
    @PutMapping("/activarJefe")
    public ResponseEntity<?> activarJefe(@RequestBody JefeDTO jefeDTO) {
        log.debug("JefeController.activarJefe() ==================> INICIO <==================");
        try {
            jefeDTO.setFlagEstado("1");
            jefeService.update(jefeDTO);
            return ResponseEntity.status(HttpStatus.OK)
                .body("Jefe activado correctamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest()
                .body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("JefeController.activarJefe() ==================> FIN <==================");
        }
    }
}
