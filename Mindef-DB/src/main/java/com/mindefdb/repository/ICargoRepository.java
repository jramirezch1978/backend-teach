package com.mindefdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindefdb.dominio.model.Cargo;

@Repository
public interface ICargoRepository extends JpaRepository<Cargo, Long>{

}
