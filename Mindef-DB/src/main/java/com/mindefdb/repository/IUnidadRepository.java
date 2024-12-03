package com.mindefdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindefdb.dominio.model.Unidad;

@Repository
public interface IUnidadRepository extends JpaRepository<Unidad, Long> {

	List<Unidad> findAllByOrderByIdCodUnidadAsc();
}
