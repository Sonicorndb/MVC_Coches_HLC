package com.hlc.coches_mvc.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlc.coches_mvc.entidad.Coche;
import com.hlc.coches_mvc.repositorio.CocheRepositorio;

@Service //construye una clase de Servicio que se conecta a varios repositorios y agrupa su funcionalidad
public class CocheServicio {
	
	@Autowired
	private CocheRepositorio cocheRepositorio;
	
    public CocheServicio(CocheRepositorio cocheRepositorio) {
        this.cocheRepositorio = cocheRepositorio;
    }

    public Iterable<Coche> listarTodosLosCoches() {
        return cocheRepositorio.findAll();
    }

    public Coche guardarCoche(Coche coche) {
        return cocheRepositorio.save(coche);
    }

    public Coche obtenerCochePorId(Long id) {
        return cocheRepositorio.findById(id).orElseThrow(() -> 
            new IllegalArgumentException("Coche no encontrado con id: " + id));
    }

    public void eliminarCoche(Long id) {
        cocheRepositorio.deleteById(id);
    }
}
