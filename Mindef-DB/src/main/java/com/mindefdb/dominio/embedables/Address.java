package com.mindefdb.dominio.embedables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
	
	@Column(name = "tipo_zona", length = 20, nullable= false)
	private String tipoZona;
	
	@Column(name = "descripcion_zona", length = 200, nullable= false)
	private String descripcionZona;
	
	@Column(name = "tipo_via", length = 20, nullable= false)
	private String tipoVia;
	
	@Column(name = "descripcion_via", length = 200, nullable= false)
	private String descripcionVia;
	
	@Column(name = "nro_manzana", length = 10)
	private String nroManzana;
	
	@Column(name = "nro_lote", length = 3)
	private String nroLote;
	
	@Column(name = "numero", length = 3)
	private String numero;

	@Column(name = "interior", length = 3)
	private String interior;

	@Column(name = "distrito", length = 150, nullable= false)
	private String distrito;
	
	@Column(name = "provincia", length = 150, nullable= false)
	private String provincia;
	
	@Column(name = "departamento", length = 150, nullable= false)
	private String departamento;
	
	@Column(name = "referencia", length = 200)
    private String referencia;
	
	@Column(name = "codigo_postal", length = 10, nullable= false)
    private String codigoPostal;
	
}
