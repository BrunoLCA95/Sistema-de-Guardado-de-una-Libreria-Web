package com.example.demo.repository;

import com.example.demo.entity.Libro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends CrudRepository<Libro, String>{
        
}
