package com.mindefdb.dominio.model;

import java.io.Serializable;

import com.mindefdb.dominio.ancestors.IModelEntity;
import com.mindefdb.dominio.auditable.DataAuditable;
import com.mindefdb.dominio.embedables.FlagEstado;
import com.mindefdb.dominio.embedables.NombreCompleto;

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
@Table(name = "t_m_personal",
	uniqueConstraints = {
        @UniqueConstraint(name = "PK_T_M_PERSONAL", columnNames = "id_personal")
	})
public class Personal extends DataAuditable implements Serializable, IModelEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4586574306477737124L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_personal", columnDefinition = "NUMERIC(8,0)")
	private Long idPersonal;
	
	@Embedded
    private NombreCompleto nombreCompleto;
	
	@Embedded
    private FlagEstado flagEstado;
}
