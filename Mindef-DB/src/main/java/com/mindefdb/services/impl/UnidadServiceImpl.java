package com.mindefdb.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindefdb.dominio.model.Unidad;
import com.mindefdb.dtos.UnidadDTO;
import com.mindefdb.repository.IUnidadRepository;
import com.mindefdb.services.IUnidadService;
import com.mindefdb.transformers.impl.UnidadTransformer;

@Service
public class UnidadServiceImpl implements IUnidadService{
	
	@Autowired
	private IUnidadRepository unidadRepository;
	
	@Override
	public UnidadDTO insertar(UnidadDTO unidadDto) {
		
		Unidad unidad = (Unidad) UnidadTransformer.builder().build().parserDtoToModel(unidadDto);
		
		unidad.setCreadoPor("SYSTEM");
		unidad.setFechaCreacion(LocalDateTime.now());
		
		unidadRepository.save(unidad);
		
		UnidadDTO dtoRetorno = (UnidadDTO) UnidadTransformer.builder().build().parserModelToDto(unidad);
		
		return dtoRetorno;
	}
	
	@Override
	public UnidadDTO update(UnidadDTO unidadDto) {
		
		Unidad unidad = (Unidad) UnidadTransformer.builder().build().parserDtoToModel(unidadDto);
		
		unidad.setModificadoPor("SYSTEM");
		unidad.setFechaModificacion(LocalDateTime.now());
		
		unidadRepository.save(unidad);
		
		UnidadDTO dtoRetorno = (UnidadDTO) UnidadTransformer.builder().build().parserModelToDto(unidad);
		
		return dtoRetorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UnidadDTO> getAll() {
		List<Unidad> lista = unidadRepository.findAllByOrderByIdCodUnidadAsc();
		
		List<UnidadDTO> listaRetorno = UnidadTransformer.builder().build().parserModelToDTO(lista);
		
		return listaRetorno;
	}

	@Override
	public void eliminar(Long idCodUnidad) {
		
		unidadRepository.deleteById(idCodUnidad);
		
	}

	@Override
	public UnidadDTO getById(Long idCodUnidad) throws Exception {
		Optional<Unidad> optUnidad = unidadRepository.findById(idCodUnidad);
		
		if (optUnidad.isEmpty())
			throw new Exception ("No existe la unidad con codigo " + idCodUnidad.toString());
		
		UnidadDTO unidadDto = (UnidadDTO) UnidadTransformer.builder().build().parserModelToDto(optUnidad.get());
		
		return unidadDto;
	}

}
