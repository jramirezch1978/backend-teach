package com.mindefdb.dtos;

import com.mindefdb.dtos.ancestors.AncestorDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JefeDTO extends AncestorDTO{
	private Long idJefe;
	private String primerNombre;
	private String segundoNombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String flagEstado;
	
	private String tipoZona;
	private String descripcionZona;
	private String tipoVia;
	private String descripcionVia;
	private String nroManzana;
	private String nroLote;
	private String numero;
	private String interior;
	private String distrito;
	private String provincia;
	private String departamento;
    private String referencia;
    private String codigoPostal;
	
    private Long idCargo;

    private Long idCodUnidad;
}
