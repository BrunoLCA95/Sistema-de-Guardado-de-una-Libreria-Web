package com.example.demo.service;

import com.example.demo.commons.GenericService;
import com.example.demo.entity.Libro;

public interface LibroService extends GenericService<Libro, String>{
    Boolean validarAutor(Libro libro);
    Boolean validarEditorial(Libro libro);
    Boolean validarTitulo(Libro libro);
    Boolean validarId(Libro libro);
    Integer obtenerEjRestantes(Libro libro);

}
