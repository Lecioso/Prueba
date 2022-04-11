package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Almacen;

public interface IAlmacenService {

	public Integer insert(Almacen almacen);

	List<Almacen> list();

	public void delete(int id);

	Optional<Almacen> listarId(int idAlmacen);

}
