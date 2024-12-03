package com.mindefdb.controllers.nivelesMadurez;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.mindefdb.dtos.UserDTO;
import com.mindefdb.services.IUserService;

@RestController
@RequestMapping("/api/usersL3")
public class Level3Controller {
	
	@Autowired
	private IUserService userService;

    @GetMapping("/{id}")
    public EntityModel<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = userService.findById(id);

        // Creamos los enlaces relevantes
        return EntityModel.of(user,
            // Link al propio recurso
            linkTo(methodOn(Level3Controller.class)
                .getUser(id)).withSelfRel(),
            
            // Link a la colección de órdenes del usuario
            linkTo(methodOn(OrderController.class)
                .getUserOrders(id)).withRel("orders"),
            
            // Link a la colección de direcciones del usuario
            linkTo(methodOn(AddressController.class)
                .getUserAddresses(id)).withRel("addresses"),
            
            // Link para actualizar
            linkTo(methodOn(Level3Controller.class)
                .updateUser(id, null)).withRel("update"),
            
            // Link condicional basado en estado
            user.getEstado().equals(UserStatus.ACTIVE) ?
                linkTo(methodOn(Level3Controller.class)
                    .deactivateUser(id)).withRel("deactivate") :
                linkTo(methodOn(Level3Controller.class)
                    .activateUser(id)).withRel("activate")
        );
    }
    
    @PutMapping("/activate/{id}")
    private ResponseEntity<Object> activateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
    
    @PutMapping("/deactivate/{id}")
	private ResponseEntity<Object> deactivateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/{id}")
    private ResponseEntity<Object> updateUser(Long id, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping
    public CollectionModel<EntityModel<UserDTO>> getAllUsers() {
        List<EntityModel<UserDTO>> users = userService.findAll().stream()
            .map(user -> EntityModel.of(user,
                linkTo(methodOn(Level3Controller.class)
                    .getUser(user.getId())).withSelfRel(),
                linkTo(methodOn(Level3Controller.class)
                    .getAllUsers()).withRel("users")))
            .collect(Collectors.toList());

        return CollectionModel.of(users,
            linkTo(methodOn(Level3Controller.class)
                .getAllUsers()).withSelfRel(),
            linkTo(methodOn(Level3Controller.class)
                .createUser(null)).withRel("create-user"));
    }
	
	@PostMapping
    private ResponseEntity<Object> createUser(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
