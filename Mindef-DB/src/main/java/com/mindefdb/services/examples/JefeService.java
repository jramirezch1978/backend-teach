package com.mindefdb.services.examples;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindefdb.dominio.model.Jefe;
import com.mindefdb.dtos.JefeDTO;
import com.mindefdb.repository.IJefeRepository;
import com.mindefdb.services.IJefeService;
import com.mindefdb.transformers.impl.JefeTransformer;

@Service
@Transactional
public class JefeService implements IJefeService {
    
    @Autowired
    private IJefeRepository jefeRepository;
    
    @Override
    public JefeDTO insertar(JefeDTO jefeDto) {
        Jefe jefe = (Jefe) JefeTransformer.builder().build().parserDtoToModel(jefeDto);
        
        jefe.setCreadoPor("SYSTEM");
        jefe.setFechaCreacion(LocalDateTime.now());
        
        jefeRepository.save(jefe);
        
        JefeDTO dtoRetorno = (JefeDTO) JefeTransformer.builder().build().parserModelToDto(jefe);
        
        return dtoRetorno;
    }
    
    @Override
    public JefeDTO update(JefeDTO jefeDto) {
        Jefe jefe = (Jefe) JefeTransformer.builder().build().parserDtoToModel(jefeDto);
        
        jefe.setModificadoPor("SYSTEM");
        jefe.setFechaModificacion(LocalDateTime.now());
        
        jefeRepository.save(jefe);
        
        JefeDTO dtoRetorno = (JefeDTO) JefeTransformer.builder().build().parserModelToDto(jefe);
        
        return dtoRetorno;
    }
    
    @Override
    public List<JefeDTO> getAll() {
        List<Jefe> lista = jefeRepository.findAll();
        List<JefeDTO> listaRetorno = JefeTransformer.builder().build().parserModelToDTO(lista);
        return listaRetorno;
    }
    
    @Override
    public void eliminar(Long idJefe) {
        jefeRepository.deleteById(idJefe);
    }
    
    @Override
    public JefeDTO getById(Long idJefe) throws Exception {
        Optional<Jefe> optJefe = jefeRepository.findById(idJefe);
        
        if (optJefe.isEmpty())
            throw new Exception("No existe el Jefe con código " + idJefe.toString());
            
        JefeDTO jefeDto = (JefeDTO) JefeTransformer.builder().build().parserModelToDto(optJefe.get());
        
        return jefeDto;
    }
}