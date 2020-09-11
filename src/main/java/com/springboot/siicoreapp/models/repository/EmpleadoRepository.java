package com.springboot.siicoreapp.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.siicoreapp.models.entity.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
