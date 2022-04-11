package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entities.Producto;
import pe.edu.upc.serviceinterface.IAlmacenService;
import pe.edu.upc.serviceinterface.IClienteService;
import pe.edu.upc.serviceinterface.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IAlmacenService almacenService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IProductoService productoService;

	@GetMapping("/new")
	public String newProducto(Model model) {

		model.addAttribute("producto", new Producto());
		model.addAttribute("listaAlmacenes", almacenService.list());
		model.addAttribute("listaClientes", clienteService.list());
		return "producto/formProducto";

	}

	@GetMapping("/list")
	public String listProducto(Model model) {

		try {

			model.addAttribute("listaProductos", productoService.list());

		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "producto/listProducto";
	}

	@PostMapping("/save")
	public String saveProducto(@Valid @ModelAttribute(value = "servicio") Producto producto, BindingResult result,
			Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("listaAlmacenes", almacenService.list());
			model.addAttribute("listaClientes", clienteService.list());
			return "producto/formProducto";
		} else {
			productoService.insert(producto);
			model.addAttribute("mensaje", "Se realizó bien!!");
			status.setComplete();
			return "redirect:/productos/list";
		}

	}

	@RequestMapping("/delete")
	public String deleteProducto(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		try {

			if (id != null && id > 0) {

				productoService.delete(id);
				model.put("mensaje", "Se eliminó correctamente");

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrio un mensaje");
		}
		return "redirect:/productos/list";
	}

}
