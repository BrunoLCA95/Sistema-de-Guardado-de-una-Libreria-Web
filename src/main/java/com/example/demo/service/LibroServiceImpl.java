package com.example.demo.service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Editorial;
import com.example.demo.entity.Libro;
import com.example.demo.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends GenericServiceImpl<Libro,String> implements LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;
    @Autowired
    private LibroService libroService;

    @Override
    public CrudRepository<Libro, String> getDao() {
        return libroRepository;
    }

    @Override
    public Boolean validarAutor(Libro libro) {
        for (Autor autorBD : autorService.getAll()) {
            if (libro.getAutor().equals(autorBD)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean validarEditorial(Libro libro) {
        for (Editorial editorialBD : editorialService.getAll()) {
            if (libro.getEditorial().equals(editorialBD)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean validarTitulo(Libro libro) {
        for (Libro libroBD : libroService.getAll()) {
            if (libro.getTitulo().equalsIgnoreCase(libroBD.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean validarId(Libro libro) {
        for (Libro libroBD : libroService.getAll()) {
            if (libro.getId().equals(libroBD.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer obtenerEjRestantes(Libro libro) {
        int ejTotales = libro.getEjemplares();
        int ejPrestados = libro.getEjemplaresPrestados();
        int ejRestantes = ejTotales-ejPrestados;

        return ejRestantes;
    }
  
}
