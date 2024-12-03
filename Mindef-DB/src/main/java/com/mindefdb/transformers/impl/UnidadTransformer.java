package com.mindefdb.transformers.impl;

import com.mindefdb.dominio.ancestors.IModelEntity;
import com.mindefdb.dominio.model.Unidad;
import com.mindefdb.dtos.UnidadDTO;
import com.mindefdb.dtos.ancestors.AncestorDTO;
import com.mindefdb.transformers.ITransformer;

import lombok.Builder;

@Builder
public class UnidadTransformer implements ITransformer{

	@Override
	public IModelEntity parserDtoToModel(AncestorDTO dto) {
		
		Unidad unidad = new Unidad();
		UnidadDTO unidadDto = (UnidadDTO) dto;
		
		if(unidadDto.getIdCodUnidad() != null) {
			unidad.setIdCodUnidad(unidadDto.getIdCodUnidad());
		}
		
		unidad.setNombre(unidadDto.getNombre());
		unidad.setSigla(unidadDto.getSigla());
		unidad.setFlagEstado("1");
		
		return unidad;
	}

	@Override
	public AncestorDTO parserModelToDto(IModelEntity model) {
		UnidadDTO unidadDto = new UnidadDTO();
		Unidad unidad = (Unidad) model;
		
		unidadDto.setNombre(unidad.getNombre());
		unidadDto.setSigla(unidad.getSigla());
		unidadDto.setFlagEstado(unidad.getFlagEstado().getFlagEstado());
		unidadDto.setIdCodUnidad(unidad.getIdCodUnidad());
		
		
		unidadDto.setCreadoPor(unidad.getCreadoPor());
		unidadDto.setFechaCreacion(unidad.getFechaCreacion());
		unidadDto.setModificadoPor(unidad.getModificadoPor());
		unidadDto.setFechaModificacion(unidad.getFechaModificacion());
		
		return unidadDto;
	}

}
