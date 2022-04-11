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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Cliente;
import pe.edu.upc.serviceimplements.ClienteServiceImpl;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteService;

	@GetMapping("/new")
	public String newCliente(Model model) {

		model.addAttribute("cliente", new Cliente());
		return "cliente/formCliente";

	}

	@PostMapping("/save")
	public String saveCliente(@Valid @ModelAttribute(value = "cliente") Cliente cliente, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {

			return "cliente/formCliente";

		} else {

			int rpta = clienteService.insert(cliente);
			if (rpta > 0) {

				model.addAttribute("mensaje", "Ya existe");
				return "/cliente/formCliente";

			} else {

				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();

			}

		}
		model.addAttribute("listaClientes", clienteService.list());
		return "/cliente/formCliente";
	}

	@GetMapping("/list")
	public String listCliente(Model model) {

		try {

			model.addAttribute("listaClientes", clienteService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "cliente/listCliente";
	}

	@RequestMapping("/delete")
	public String deleteCliente(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {

			if (id != null && id > 0) {
				clienteService.delete(id);
				model.put("mensaje", "Se eliminó correctamente");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un mensaje");
		}
		return "redirect:/clientes/list";
	}

	@GetMapping("/detalle/{id}")
	public String detailsCliente(@PathVariable(value = "id") int id, Model model) {

		try {

			Optional<Cliente> cliente = clienteService.listarId(id);
			if (!cliente.isPresent()) {
				model.addAttribute("info", "Categoria no existe");
				return "redirect:/clientes/list";
			} else {
				model.addAttribute("cliente", cliente.get());

			}
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "/cliente/update";
	}

}
