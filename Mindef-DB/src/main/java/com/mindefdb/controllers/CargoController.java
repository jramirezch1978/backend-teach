package com.mindefdb.controllers;

import org.slf4j.LoggerFactory;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mindefdb.dtos.CargoDTO;
import com.mindefdb.services.ICargoService;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/cargos")
public class CargoController {
    
    @Autowired 
    private ICargoService cargoService;
    
    private Logger log = LoggerFactory.getLogger(CargoController.class.getName());
    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(@Valid @RequestBody CargoDTO cargoDTO) {
        log.debug("CargoController.insertar() ==================> INICIO <==================");
        try {
            CargoDTO retorno = cargoService.insertar(cargoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.insertar() ==================> FIN <==================");
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long idCodCargo) {
        log.debug("CargoController.eliminar() ==================> INICIO <==================");
        try {
            cargoService.eliminar(idCodCargo);
            return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado satisfactoriamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.eliminar() ==================> FIN <==================");
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        log.debug("CargoController.getAll() ==================> INICIO <==================");
        try {
            List<CargoDTO> listaRetorno = cargoService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(listaRetorno);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.getAll() ==================> FIN <==================");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long idCodCargo) {
        log.debug("CargoController.getById() ==================> INICIO <==================");
        try {
            CargoDTO objRetorno = cargoService.getById(idCodCargo);
            return ResponseEntity.status(HttpStatus.OK).body(objRetorno);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.getById() ==================> FIN <==================");
        }
    }
    
    @GetMapping("/hateoas/{id}")
    public ResponseEntity<?> getHateoasById(@PathVariable("id") Long idCodCargo) {
        log.debug("CargoController.getHateoasById() ==================> INICIO <==================");
        try {
            CargoDTO objRetorno = cargoService.getById(idCodCargo);
            
            EntityModel<CargoDTO> resource = EntityModel.of(objRetorno);
            
            // Agregar enlace a sí mismo
            resource.add(linkTo(methodOn(CargoController.class)
                .getHateoasById(idCodCargo))
                .withSelfRel());
            
            // Agregar enlace a la lista completa
            resource.add(linkTo(methodOn(CargoController.class)
                .getAll())
                .withRel("todos-los-cargos"));
            
            // Agregar enlace para actualizar
            resource.add(linkTo(methodOn(CargoController.class)
                .update(objRetorno))
                .withRel("actualizar"));
            
            // Agregar enlace para eliminar
            resource.add(linkTo(methodOn(CargoController.class)
                .eliminar(idCodCargo))
                .withRel("eliminar"));
            
            if (objRetorno.getFlagEstado().equals("1")) {
                resource.add(linkTo(methodOn(CargoController.class)
                    .desactivarCargo(objRetorno))
                    .withRel("deactivate"));
            } else {
                resource.add(linkTo(methodOn(CargoController.class)
                    .activarCargo(objRetorno))
                    .withRel("activarse"));
            }
            
            return ResponseEntity.status(HttpStatus.OK).body(resource);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.getHateoasById() ==================> FIN <==================");
        }
    }
    
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody CargoDTO cargoDTO) {
        log.debug("CargoController.update() ==================> INICIO <==================");
        try {
            cargoService.update(cargoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Grabación realizada correctamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.update() ==================> FIN <==================");
        }
    }
    
    @PutMapping("/desactivarCargo")
    public ResponseEntity<?> desactivarCargo(@RequestBody CargoDTO cargoDTO) {
        log.debug("CargoController.desactivarCargo() ==================> INICIO <==================");
        try {
            cargoDTO.setFlagEstado("0");
            cargoService.update(cargoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Cargo desactivado correctamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.desactivarCargo() ==================> FIN <==================");
        }
    }
    
    @PutMapping("/activarCargo")
    public ResponseEntity<?> activarCargo(@RequestBody CargoDTO cargoDTO) {
        log.debug("CargoController.activarCargo() ==================> INICIO <==================");
        try {
            cargoDTO.setFlagEstado("1");
            cargoService.update(cargoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Cargo activado correctamente");
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
        } finally {
            log.debug("CargoController.activarCargo() ==================> FIN <==================");
        }
    }
}