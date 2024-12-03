package com.mindefdb.services.examples;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.dominio.model.Cargo;
import com.mindefdb.dtos.CargoDTO;
import com.mindefdb.repository.ICargoRepository;
import com.mindefdb.services.ICargoService;
import com.mindefdb.transformers.impl.CargoTransformer;

@Service
@Transactional
public class CargoService implements ICargoService{
	@Autowired
	private ICargoRepository cargoRepository;
	
	@Override
	public CargoDTO insertar(CargoDTO cargoDto) {
		Cargo cargo = (Cargo) CargoTransformer.builder().build().parserDtoToModel(cargoDto);
		
		cargo.setCreadoPor("SYSTEM");
		cargo.setFechaCreacion(LocalDateTime.now());
		
		cargoRepository.save(cargo);
		
		CargoDTO dtoRetorno = (CargoDTO) CargoTransformer.builder().build().parserModelToDto(cargo);
		
		return dtoRetorno;
	}

	@Override
	public CargoDTO update(CargoDTO cargoDto) {
		Cargo cargo = (Cargo) CargoTransformer.builder().build().parserDtoToModel(cargoDto);
		
		cargo.setModificadoPor("SYSTEM");
		cargo.setFechaModificacion(LocalDateTime.now());
		
		cargoRepository.save(cargo);
		
		CargoDTO dtoRetorno = (CargoDTO) CargoTransformer.builder().build().parserModelToDto(cargo);
		
		return dtoRetorno;
	}

	@Override
	public List<CargoDTO> getAll() {
		List<Cargo> lista = cargoRepository.findAll();
		
		List<CargoDTO> listaRetorno = CargoTransformer.builder().build().parserModelToDTO(lista);
		
		return listaRetorno;
	}

	@Override
	public void eliminar(Long idCodCargo) {
		cargoRepository.deleteById(idCodCargo);
		
	}

	@Override
	public CargoDTO getById(Long idCodCargo) throws Exception {
		Optional<Cargo> optCargo = cargoRepository.findById(idCodCargo);
		
		if (optCargo.isEmpty())
			throw new Exception ("No existe el Cargo con codigo " + idCodCargo.toString());
		
		CargoDTO CargoDto = (CargoDTO) CargoTransformer.builder().build().parserModelToDto(optCargo.get());
		
		return CargoDto;
	}



}
