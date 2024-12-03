package com.mindefdb.transformers.impl;

import com.mindefdb.dominio.ancestors.IModelEntity;
import com.mindefdb.dominio.embedables.FlagEstado;
import com.mindefdb.dominio.model.Cargo;
import com.mindefdb.dtos.CargoDTO;
import com.mindefdb.dtos.ancestors.AncestorDTO;
import com.mindefdb.transformers.ITransformer;

import lombok.Builder;

@Builder
public class CargoTransformer implements ITransformer<Cargo, CargoDTO>{

	@Override
	public IModelEntity parserDtoToModel(AncestorDTO dto) {
		Cargo cargo = new Cargo();
		CargoDTO cargoDto = (CargoDTO) dto;
		
		if(cargoDto.getIdCargo() != null) {
			cargo.setIdCargo(cargoDto.getIdCargo());
		}
		
		cargo.setNombreCargo(cargoDto.getNombreCargo());
		cargo.setFlagEstado(FlagEstado.builder().flagEstado("1").build());
		
		return cargo;
	}

	@Override
	public AncestorDTO parserModelToDto(IModelEntity model) {
		CargoDTO cargoDTO = new CargoDTO();
		Cargo cargo = (Cargo) model;
		
		cargoDTO.setNombreCargo(cargo.getNombreCargo());
		cargoDTO.setFlagEstado(cargo.getFlagEstado().getFlagEstado());
		cargoDTO.setIdCargo(cargo.getIdCargo());
		
		
		cargoDTO.setCreadoPor(cargo.getCreadoPor());
		cargoDTO.setFechaCreacion(cargo.getFechaCreacion());
		cargoDTO.setModificadoPor(cargo.getModificadoPor());
		cargoDTO.setFechaModificacion(cargo.getFechaModificacion());
		
		return cargoDTO;
	}

}
