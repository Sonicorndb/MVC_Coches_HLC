package com.hlc.coches_mvc.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hlc.coches_mvc.entidad.Coche;

@Repository //indica que esta clase interactúa con los datos (almacenado, búsqueda, modificaciones, eliminaciones...)
public interface CocheRepositorio extends CrudRepository<Coche, Long>{

}
