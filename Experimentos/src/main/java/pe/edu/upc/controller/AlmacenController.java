package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Almacen;
import pe.edu.upc.serviceinterface.IAlmacenService;

@Controller
@SessionAttributes
@RequestMapping("/almacenes")
public class AlmacenController {

	@Autowired
	private IAlmacenService almacenService;

	@GetMapping("/new")
	public String newAlmacen(Model model) {

		model.addAttribute("almacen", new Almacen());
		return "almacen/formAlmacen";

	}

	@PostMapping("/save")
	public String saveAlmacen(@Valid @ModelAttribute(value = "almacen") Almacen almacen, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {

			return "almacen/formAlmacen";

		} else {
			int rpta = almacenService.insert(almacen);
			if (rpta > 0) {

				model.addAttribute("mensaje", "Ya existe");
				return "almacen/formAlmacen";

			} else {

				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();

			}
		}
		model.addAttribute("listaAlmacenes", almacenService.list());
		return "almacen/formAlmacen";
	}

	@GetMapping("/list")
	public String listAlmacen(Model model) {

		try {

			model.addAttribute("listaAlmacenes", almacenService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "almacen/listAlmacen";

	}

	@RequestMapping("/delete")
	public String deleteAlmacen(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {

			if (id != null && id > 0) {

				almacenService.delete(id);
				model.put("mensaje", "Ocurrio un mensaje");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un mensaje");
		}
		return "redirect:/almacenes/list";
	}

	@GetMapping("/detalle/{id}")
	public String detailsCategory(@PathVariable(value = "id") int id, Model model) {

		try {

			Optional<Almacen> almacen = almacenService.listarId(id);

			if (!almacen.isPresent()) {
				model.addAttribute("info", "Categoría no existe");
				return "redirect:/almacenes/list";
			} else {

				model.addAttribute("almacen", almacen.get());

			}

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/almacen/update";
	}

}
