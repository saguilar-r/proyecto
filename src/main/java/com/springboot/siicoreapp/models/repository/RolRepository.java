package com.springboot.siicoreapp.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.siicoreapp.models.entity.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

}
