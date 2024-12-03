package com.mindefdb.services;

import java.util.List;

import com.mindefdb.dtos.UnidadDTO;

public interface IUnidadService {
	
	public UnidadDTO insertar(UnidadDTO unidadDto);
	public UnidadDTO update(UnidadDTO unidadDto);
	
	public List<UnidadDTO> getAll();
	
	public void eliminar(Long idCodUnidad);
	public UnidadDTO getById(Long idCodUnidad) throws Exception;

}
