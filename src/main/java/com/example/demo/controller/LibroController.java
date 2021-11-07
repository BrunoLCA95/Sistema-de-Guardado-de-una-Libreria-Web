package com.example.demo.controller;

import com.example.demo.entity.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.EditorialService;
import com.example.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", libroService.getAll());
        return "libreria";
    }

    @GetMapping("/libros-from/{id}")
    public String showSave(@PathVariable("id") String id, Model model){
        
        model.addAttribute("listaAutores", autorService.getAll());
        model.addAttribute("listaEditoriales", editorialService.getAll());

        char [] num_id = id.toCharArray();
		String id_num = "";
		for (int i = 0; i < 8; i++) {
			if (Character.isDigit(num_id[i])) {
				id_num=id_num+num_id[i];
			}
		}

		Long idn = Long.valueOf(id_num);

		if(idn != 0) {
			model.addAttribute("libro", libroService.get(id));
		}else {
			model.addAttribute("libro", new Libro());	
		}
		return "libros-from";
    }

    @PostMapping("/libros-from")
    public String save(Libro libro, ModelMap model){
        model.addAttribute("listaAutores", autorService.getAll());
        model.addAttribute("listaEditoriales", editorialService.getAll());

        libro.setEjemplaresRestantes(libroService.obtenerEjRestantes(libro));

        if (!libroService.validarTitulo(libro)) {
            if (libroService.validarAutor(libro) && libroService.validarEditorial(libro)) {
                libroService.save(libro);
                model.put("exito", "Libro guardado");
            } else {
                model.put("error", "El Autor o Editorial no se encuentran registrados");
            } 
        } else {
            if (libroService.validarId(libro)) {
                libroService.save(libro);
                model.put("exito", "Libro modificado");
            } else {
                model.put("error", "El Libro Ya se encuentra registrado");
            }
        }      
		return "libros-from";
    }

    @GetMapping("/libro-delete/{id}")
    public String delete(@PathVariable String id, Model model){
        libroService.delete(id);
        return "redirect:/";
    }

}
