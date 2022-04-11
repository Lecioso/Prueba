package pe.edu.upc.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Producto;
import pe.edu.upc.repository.IProductoRepository;
import pe.edu.upc.serviceinterface.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional
	public Producto insert(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	@Transactional
	public List<Producto> list() {

		List<Producto> lista = productoRepository.list();
		for (Producto p : lista) {

			p.setPrecioProducto(p.getCantidadProducto() * p.getPrecioUnitProducto());

		}

		return lista;

	}

	@Override
	public void delete(int id) {
		productoRepository.deleteById(id);

	}

}
