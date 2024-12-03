package com.mindefdb.dominio.model;

import java.io.Serializable;
import java.util.Date;

import com.mindefdb.dominio.ancestors.IModelEntity;
import com.mindefdb.dominio.auditable.DataAuditable;
import com.mindefdb.dominio.embedables.Address;
import com.mindefdb.dominio.embedables.FlagEstado;
import com.mindefdb.dominio.embedables.NombreCompleto;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "t_t_chofer",
	uniqueConstraints = {
        @UniqueConstraint(name = "PK_T_T_CHOFER", columnNames = "id_chofer"),
        @UniqueConstraint(name = "UK_T_T_CHOFER_DNI", columnNames = "dni"),
        @UniqueConstraint(name = "UK_T_T_CHOFER_NRO_LICENCIA", columnNames = "nro_licencia"),
	})
public class Chofer extends DataAuditable implements Serializable, IModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5616837701178813239L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_chofer", columnDefinition = "NUMERIC(8,0)")
	private Long idChofer;
	
	@Embedded
    private NombreCompleto nombreCompleto;
	
	@Column(name ="celular", length = 9, nullable = false)
	private String celular;
	
	@Column(name ="nro_licencia", length = 9, nullable = false)
	private String nroLicencia;
	
	@Column(name ="dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name ="fecha_vigente", columnDefinition = "DATE") //columnDefinition = "TIMESTAMP DEFAULT CURRENT_DATE")
	private Date fechaVigente;
	
	@Column(name ="observaciones", length = 3000)
	private String observaciones;

	@Embedded
    private FlagEstado flagEstado;
	
	@Embedded
    private Address direccion;
	
	@ManyToOne
	@JoinColumn(name="id_cod_unidad")
	private Unidad unidad;

}
