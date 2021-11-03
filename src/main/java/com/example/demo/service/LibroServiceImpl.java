package com.example.demo.service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.entity.Libro;
import com.example.demo.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends GenericServiceImpl<Libro,String> implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public CrudRepository<Libro, String> getDao() {
        return libroRepository;
    }

    
}
