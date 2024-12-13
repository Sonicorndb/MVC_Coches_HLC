package com.hlc.coches_mvc.config;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.coches_mvc.entidad.Coche;
import com.hlc.coches_mvc.servicio.CocheServicio;

import jakarta.annotation.PostConstruct;

@Component //indica el componente de spring boot (es necesario para registrar la clase)
public class InicializarDatos {
	 @Autowired //auto-inyección de dependencias
	    private CocheServicio cocheServicio;
	    
	    @PostConstruct //Define un método como método de inicialización de un bean 
	    			   //Se ejecuta después de que se complete la inyección de dependencia. 
	    public void init() {
	        // Crear y guardar algunos productos de ejemplo
	        if (cocheServicio.listarTodosLosCoches().iterator().hasNext()) {
	            // Si ya hay datos, no inicializamos.
	            return;
	        }
	        
	        Coche coche1 = new Coche();
	        coche1.setMarca("Opel");
	        coche1.setMatricula("HGDK 123");
	        coche1.setColor("Azul");
	        cocheServicio.guardarCoche(coche1);
	        
	        Coche coche2 = new Coche();
	        coche2.setMarca("Mercedes");
	        coche2.setMatricula("AAAA 456");
	        coche2.setColor("Negro");
	        cocheServicio.guardarCoche(coche2);
	    }
}
