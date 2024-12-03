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

import com.mindefdb.dtos.UnidadDTO;
import com.mindefdb.services.IUnidadService;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("api/unidades")
public class UnidadController {
	
	@Autowired 
	private IUnidadService unidadService;
	
	private Logger log = LoggerFactory.getLogger(UnidadController.class.getName());
	
	@PostMapping("/insertar")
	public ResponseEntity<?> insertar(@Valid @RequestBody UnidadDTO unidadDTO){
		log.debug("UnidadController.insertar() ==================> INICIO <==================");
		try {
			
			UnidadDTO retorno = unidadService.insertar(unidadDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.insertar() ==================> FIN <==================");
		}
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long idCodUnidad){
		log.debug("UnidadController.eliminar() ==================> INICIO <==================");
		try {
			
			unidadService.eliminar(idCodUnidad);
			return ResponseEntity.status(HttpStatus.CREATED).body("Registro eliminado satisfactoriamente");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.eliminar() ==================> FIN <==================");
		}
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		log.debug("UnidadController.getAll() ==================> INICIO <==================");
		try {
			
			List<UnidadDTO> listaRetorno = unidadService.getAll();
			return ResponseEntity.status(HttpStatus.CREATED).body(listaRetorno);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.getAll() ==================> FIN <==================");
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long idCodUnidad){
		log.debug("UnidadController.getAll() ==================> INICIO <==================");
		try {
			
			UnidadDTO objRetorno = unidadService.getById(idCodUnidad);
			return ResponseEntity.status(HttpStatus.OK).body(objRetorno);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.getAll() ==================> FIN <==================");
		}
		
	}
	
	@GetMapping("/hateoas/{id}")
	public ResponseEntity<?> getHateoasById(@PathVariable("id") Long idCodUnidad)
	{
		log.debug("UnidadController.getById() ==================> INICIO <==================");
        try {
            UnidadDTO objRetorno = unidadService.getById(idCodUnidad);
            
            EntityModel<UnidadDTO> resource = EntityModel.of(objRetorno);
            
            // Agregar enlace a sí mismo
            resource.add(linkTo(methodOn(UnidadController.class)
                .getHateoasById(idCodUnidad))
                .withSelfRel());
            
            // Agregar enlace a la lista completa
            resource.add(linkTo(methodOn(UnidadController.class)
                .getAll())
                .withRel("todas-las-unidades"));
            
            // Agregar enlace para actualizar
            resource.add(linkTo(methodOn(UnidadController.class)
                .update(objRetorno))
                .withRel("actualizar"));
            
            // Agregar enlace para eliminar
            resource.add(linkTo(methodOn(UnidadController.class)
                .eliminar(idCodUnidad))
                .withRel("eliminar"));
            
            if (objRetorno.getFlagEstado().equals("1")) {
            	// Agregar enlace para eliminar
                resource.add(linkTo(methodOn(UnidadController.class)
                    .desactivarUnidad(objRetorno))
                    .withRel("deactivate"));
            }else {
            	// Agregar enlace para eliminar
                resource.add(linkTo(methodOn(UnidadController.class)
                    .activarUnidad(objRetorno))
                    .withRel("activarse"));
            }
            
            return ResponseEntity.status(HttpStatus.OK).body(resource);
            
        } catch(Exception ex) {
        	
            ex.printStackTrace();
            return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
            
        } finally {
        	
            log.debug("UnidadController.getById() ==================> FIN <==================");
        }
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody UnidadDTO unidadDTO){
		log.debug("UnidadController.update() ==================> INICIO <==================");
		try {
			
			unidadService.update(unidadDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body("Grabacion realizada correctamente");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.update() ==================> FIN <==================");
		}
		
	}
	
	@PutMapping("/desactivarUnidad")
	public ResponseEntity<?> desactivarUnidad(@RequestBody UnidadDTO unidadDTO){
		log.debug("UnidadController.update() ==================> INICIO <==================");
		try {
			
			unidadDTO.setFlagEstado("0");
			unidadService.update(unidadDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Grabacion realizada correctamente");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.update() ==================> FIN <==================");
		}
		
	}
	
	@PutMapping("/activarUnidad")
	public ResponseEntity<?> activarUnidad(@RequestBody UnidadDTO unidadDTO){
		log.debug("UnidadController.update() ==================> INICIO <==================");
		try {
			
			unidadDTO.setFlagEstado("1");
			unidadService.update(unidadDTO);
			return ResponseEntity.status(HttpStatus.OK).body("Grabacion realizada correctamente");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Ha ocurrido una exception: " + ex.getMessage());
		}finally {
			log.debug("UnidadController.update() ==================> FIN <==================");
		}
		
	}
}
