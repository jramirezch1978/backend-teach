package com.mindefdb.dtos;

import com.mindefdb.dtos.ancestors.AncestorDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoDTO extends AncestorDTO{
	private Long idCargo;
	private String nombreCargo;
    private String flagEstado;
    
    
}
