package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entities.Producto;

public interface IProductoService {

	public Producto insert(Producto product);

	List<Producto> list();

	public void delete(int id);

}
