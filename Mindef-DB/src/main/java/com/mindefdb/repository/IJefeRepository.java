package com.mindefdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindefdb.dominio.model.Cargo;
import com.mindefdb.dominio.model.Jefe;

public interface IJefeRepository extends JpaRepository<Jefe, Long>{

}
