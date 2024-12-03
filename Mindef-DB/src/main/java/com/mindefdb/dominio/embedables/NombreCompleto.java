package com.mindefdb.dominio.embedables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NombreCompleto {
	@Column(name ="primer_nombre", length = 150, nullable = false )
	private String primerNombre;
	
	@Column(name ="segundo_nombre", length = 150, nullable = false )
	private String segundoNombre;

	@Column(name ="apellido_paterno", length = 150, nullable = false)
	private String apellidoPaterno;
	
	@Column(name ="apellido_materno", length = 150, nullable = false)
	private String apellidoMaterno;
}
