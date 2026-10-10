package com.examenT2.LP2_T2_MezaDavid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_MezaDavid.model.OrdenCompraMezaDavid;
import com.examenT2.LP2_T2_MezaDavid.repository.OrdenCompraMezaDavidRepository;
import com.examenT2.LP2_T2_MezaDavid.service.OrdenCompraMezaDavidService;
import com.examenT2.LP2_T2_MezaDavid.service.ProveedorMezaDavidService;
import com.examenT2.LP2_T2_MezaDavid.service.RubroMezaDavidService;
import com.examenT2.LP2_T2_MezaDavid.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("inventario")
public class OrdenCompraMezaDavidController {
	
	private final OrdenCompraMezaDavidService ordenCompraMezaDavidService;
	private final ProveedorMezaDavidService proveedorMezaDavidService;
	private final RubroMezaDavidService rubroMezaDavidService;
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstIventario", ordenCompraMezaDavidService.getAll());		
		return "inventario/listadoMezaDavid";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("slcProveedor", proveedorMezaDavidService.getAll());
		model.addAttribute("orden", new OrdenCompraMezaDavid());
		return "inventario/nuevoMezaDavid";
	}
	
	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraMezaDavid o, RedirectAttributes flash) {
		
		var response = ordenCompraMezaDavidService.create(o);
		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		
		flash.addFlashAttribute("alert",alert);	
		return "redirect:/inventario/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("slcProveedor", proveedorMezaDavidService.getAll());
		model.addAttribute("orden", ordenCompraMezaDavidService.getOne(id));
		return "inventario/edicionMezaDavid";
	}
	
	@PostMapping("actualizar")
	public String actualizar(@ModelAttribute OrdenCompraMezaDavid i, RedirectAttributes flash) {	
		var response = ordenCompraMezaDavidService.update(i);
		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		
		flash.addFlashAttribute("alert",alert);	
		return "redirect:/inventario/listado";
	}
}
