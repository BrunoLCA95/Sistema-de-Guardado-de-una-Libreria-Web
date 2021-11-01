package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.entity.Autor;
import com.example.demo.repository.AutorRepository;

@Service
public class AutorServiceImpl extends GenericServiceImpl<Autor, String> implements AutorService{
	
	@Autowired
	private AutorRepository autorRepository;

	@Override
	public CrudRepository<Autor, String> getDao() {
		return autorRepository;
	}
	
}
