package com.mindefdb.dtos;

import com.mindefdb.dtos.validationGroup.OnCreate;
import com.mindefdb.dtos.validationGroup.OnUpdate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
	@Null(groups = OnCreate.class, message = "ID debe ser nulo en creación")
    @NotNull(groups = OnUpdate.class, message = "ID es requerido en actualización")
    private Long id;
    
    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Nombre es requerido")
    @Size(min = 2, max = 50, groups = {OnCreate.class, OnUpdate.class}, 
          message = "Nombre debe tener entre 2 y 50 caracteres")
    private String name;
    
    @Email(groups = {OnCreate.class, OnUpdate.class}, message = "Email debe ser válido")
    @NotBlank(groups = OnCreate.class, message = "Email es requerido en creación")
    private String email;
    
    @Min(value = 18, groups = {OnCreate.class, OnUpdate.class}, 
         message = "Edad mínima es 18 años")
    private int age;
    
    @Pattern(regexp = "^\\+?[1-9][0-9]{7,14}$", 
            groups = {OnCreate.class, OnUpdate.class},
            message = "Formato de teléfono inválido")
    private String phone;
    
    @NotNull
    @Size(min = 1, max = 1)
    @NotBlank
    private String estado;
}
