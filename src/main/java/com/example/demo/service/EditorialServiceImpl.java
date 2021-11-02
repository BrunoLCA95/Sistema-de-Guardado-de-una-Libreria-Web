package com.example.demo.service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.entity.Editorial;
import com.example.demo.repository.EditorialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl extends GenericServiceImpl<Editorial, String > implements EditorialService{

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public CrudRepository<Editorial, String> getDao() {
        return editorialRepository;
    }
    
}
