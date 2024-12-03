package com.mindefdb.transformers.impl;

import com.mindefdb.dominio.ancestors.IModelEntity;
import com.mindefdb.dominio.embedables.Address;
import com.mindefdb.dominio.embedables.FlagEstado;
import com.mindefdb.dominio.embedables.NombreCompleto;
import com.mindefdb.dominio.model.Jefe;
import com.mindefdb.dtos.JefeDTO;
import com.mindefdb.dtos.ancestors.AncestorDTO;
import com.mindefdb.transformers.ITransformer;

import lombok.Builder;

@Builder
public class JefeTransformer implements ITransformer<Jefe, JefeDTO> {

    @Override
    public IModelEntity parserDtoToModel(AncestorDTO dto) {
        JefeDTO jefeDTO = (JefeDTO) dto;
        Jefe jefe = new Jefe();
        
        // Setear ID
        jefe.setIdJefe(jefeDTO.getIdJefe());
        
        // Setear Nombre Completo
        NombreCompleto nombreCompleto = new NombreCompleto();
        nombreCompleto.setPrimerNombre(jefeDTO.getPrimerNombre());
        nombreCompleto.setSegundoNombre(jefeDTO.getSegundoNombre());
        nombreCompleto.setApellidoPaterno(jefeDTO.getApellidoPaterno());
        nombreCompleto.setApellidoMaterno(jefeDTO.getApellidoMaterno());
        jefe.setNombreCompleto(nombreCompleto);
        
        // Setear correo
        jefe.setCorreo(jefeDTO.getCorreo());
        
        // Setear Flag Estado
        FlagEstado flagEstado = new FlagEstado();
        flagEstado.setFlagEstado(jefeDTO.getFlagEstado());
        jefe.setFlagEstado(flagEstado);
        
        // Setear Dirección
        Address direccion = new Address();
        direccion.setTipoZona(jefeDTO.getTipoZona());
        direccion.setDescripcionZona(jefeDTO.getDescripcionZona());
        direccion.setTipoVia(jefeDTO.getTipoVia());
        direccion.setDescripcionVia(jefeDTO.getDescripcionVia());
        direccion.setNroManzana(jefeDTO.getNroManzana());
        direccion.setNroLote(jefeDTO.getNroLote());
        direccion.setNumero(jefeDTO.getNumero());
        direccion.setInterior(jefeDTO.getInterior());
        direccion.setDistrito(jefeDTO.getDistrito());
        direccion.setProvincia(jefeDTO.getProvincia());
        direccion.setDepartamento(jefeDTO.getDepartamento());
        direccion.setReferencia(jefeDTO.getReferencia());
        direccion.setCodigoPostal(jefeDTO.getCodigoPostal());
        jefe.setDireccion(direccion);

        return jefe;
    }

    @Override
    public AncestorDTO parserModelToDto(IModelEntity model) {
        Jefe jefe = (Jefe) model;
        
        return JefeDTO.builder()
            .idJefe(jefe.getIdJefe())
            
            // Nombre Completo
            .primerNombre(jefe.getNombreCompleto().getPrimerNombre())
            .segundoNombre(jefe.getNombreCompleto().getSegundoNombre())
            .apellidoPaterno(jefe.getNombreCompleto().getApellidoPaterno())
            .apellidoMaterno(jefe.getNombreCompleto().getApellidoMaterno())
            
            // Datos básicos
            .correo(jefe.getCorreo())
            .flagEstado(jefe.getFlagEstado().getFlagEstado())
            
            // Dirección
            .tipoZona(jefe.getDireccion().getTipoZona())
            .descripcionZona(jefe.getDireccion().getDescripcionZona())
            .tipoVia(jefe.getDireccion().getTipoVia())
            .descripcionVia(jefe.getDireccion().getDescripcionVia())
            .nroManzana(jefe.getDireccion().getNroManzana())
            .nroLote(jefe.getDireccion().getNroLote())
            .numero(jefe.getDireccion().getNumero())
            .interior(jefe.getDireccion().getInterior())
            .distrito(jefe.getDireccion().getDistrito())
            .provincia(jefe.getDireccion().getProvincia())
            .departamento(jefe.getDireccion().getDepartamento())
            .referencia(jefe.getDireccion().getReferencia())
            .codigoPostal(jefe.getDireccion().getCodigoPostal())
            
            // IDs de relaciones
            .idCargo(jefe.getCargo() != null ? jefe.getCargo().getIdCargo() : null)
            .idCodUnidad(jefe.getUnidad() != null ? jefe.getUnidad().getIdCodUnidad() : null)
            .build();
    }
}