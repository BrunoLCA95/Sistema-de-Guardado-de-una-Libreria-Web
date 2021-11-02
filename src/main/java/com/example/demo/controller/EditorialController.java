package com.example.demo.controller;

import com.example.demo.entity.Editorial;
import com.example.demo.service.EditorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @RequestMapping("/")
    public String index( Model model){
        model.addAttribute("list", editorialService.getAll());
        return "editoriales";
    }


    @GetMapping("/editorial-from/{id}")
    public String showSave(@PathVariable ("id") String id, Model model){
        char [] num_id = id.toCharArray();
		String id_num = "";
		for (int i = 0; i < 8; i++) {
			if (Character.isDigit(num_id[i])) {
				id_num=id_num+num_id[i];
			}
		}

		Long idn = Long.valueOf(id_num);

		if(idn != 0) {
			model.addAttribute("editorial", editorialService.get(id));
		}else {
			model.addAttribute("editorial", new Editorial());	
		}
		return "editorial-from";
    }


    @PostMapping("/editorial-from")
    public String save(Editorial editorial, ModelMap model){

        int comp = 0;
		String a1=editorial.getNombre();
		String a2;
		String id1 = editorial.getId();
		String id2;
		int comp2 = 0;
		for (Editorial editorial2 : editorialService.getAll()) {
			a2=editorial2.getNombre();
			id2=editorial2.getId();
			if ( id1.equals(id2)) {
				comp2 = 1;
			}
			if (a1.equalsIgnoreCase(a2)) {
				comp = 1;
			}
		}
		if (comp2 != 1) {
			if(editorial.getNombre() == ""){
				model.put("error", "Falta completar campos");
			}else{
				if (comp != 1) {
					model.put("exito", "Editorial Guardado");
					editorialService.save(editorial);
				}else{
					model.put("error", "El Editorial ya se encuentra cargado");
					return "editorial-from";
				}
	
			}
		}else{
			model.put("exito", "Editorial Guardado");
			editorialService.save(editorial);
		}



		return "editorial-from";
    }


    @GetMapping("/editorial-delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		editorialService.delete(id);
		return "redirect:/";
	}







}
