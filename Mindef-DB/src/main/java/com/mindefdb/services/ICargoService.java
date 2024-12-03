package com.mindefdb.services;

import java.util.List;

import com.mindefdb.dtos.CargoDTO;

public interface ICargoService {
	public CargoDTO insertar(CargoDTO cargoDto);
	public CargoDTO update(CargoDTO cargoDto);
	
	public List<CargoDTO> getAll();
	
	public void eliminar(Long idCodCargo);
	public CargoDTO getById(Long idCodCargo) throws Exception;
}
