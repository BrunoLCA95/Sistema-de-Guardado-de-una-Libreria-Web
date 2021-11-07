package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Autor;
import com.example.demo.service.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;
	

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", autorService.getAll());
		return "autores";
	}
	
	@GetMapping("/autor-from/{id}")
	public String showSave(@PathVariable("id") String id , Model model) {
		
		char [] num_id = id.toCharArray();
		String id_num = "";
		for (int i = 0; i < 8; i++) {
			if (Character.isDigit(num_id[i])) {
				id_num=id_num+num_id[i];
			}
		}

		Long idn = Long.valueOf(id_num);

		if(idn != 0) {
			model.addAttribute("autor", autorService.get(id));
		}else {
			model.addAttribute("autor", new Autor());	
		}
		return "autor-from";
	}
	
	
	@PostMapping("/autor-from")
	public String save(Autor autor, ModelMap model) {


		int comp = 0;
		String a1=autor.getNombre();
		String a2;
		String id1 = autor.getId();
		String id2;
		int comp2 = 0;
		for (Autor autor2 : autorService.getAll()) {
			a2=autor2.getNombre();
			id2=autor2.getId();
			if ( id1.equals(id2)) {
				comp2 = 1;
			}
			if (a1.equalsIgnoreCase(a2)) {
				comp = 1;
			}
		}
		if (comp2 != 1) {
			if(autor.getNombre() == ""){
				model.put("error", "Falta completar campos");
			}else{
				if (comp != 1) {
					model.put("exito", "Autor Guardado");
					autorService.save(autor);
				}else{
					model.put("error", "El Autor ya se encuentra cargado");
					return "autor-from";
				}
	
			}
		}else{
			model.put("exito", "Autor Guardado");
			autorService.save(autor);
		}



		return "autor-from";
	}
	
	
	@GetMapping("/autor-delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		autorService.delete(id);
		
		return "redirect:/autores/";
	}
	

}

