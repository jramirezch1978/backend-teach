package com.mindefdb.services;

import java.util.List;

import com.mindefdb.dtos.JefeDTO;

public interface IJefeService {
	JefeDTO insertar(JefeDTO jefeDto);
    JefeDTO update(JefeDTO jefeDto);
    List<JefeDTO> getAll();
    void eliminar(Long idJefe);
    JefeDTO getById(Long idJefe) throws Exception;
}
