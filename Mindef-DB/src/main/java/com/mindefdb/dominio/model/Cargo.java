package com.mindefdb.dominio.model;

import java.io.Serializable;

import com.mindefdb.dominio.ancestors.IModelEntity;
import com.mindefdb.dominio.auditable.DataAuditable;
import com.mindefdb.dominio.embedables.FlagEstado;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "t_m_cargo",
	uniqueConstraints = {
        @UniqueConstraint(name = "PK_T_M_CARGO", columnNames = "id_cargo")
	})
public class Cargo extends DataAuditable implements Serializable, IModelEntity{/**
	 * 
	 */
	private static final long serialVersionUID = 3214079781831171875L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_cargo", columnDefinition = "NUMERIC(8,0)")
	private Long idCargo;
	
	@Column(name ="nombre_cargo", length = 150, nullable = false)
	private String nombreCargo;
	
	@Embedded
    private FlagEstado flagEstado;
	
}
