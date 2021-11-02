package com.example.demo.repository;

import com.example.demo.entity.Editorial;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends CrudRepository<Editorial, String> {
    
}
