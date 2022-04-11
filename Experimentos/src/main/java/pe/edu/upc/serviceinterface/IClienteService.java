package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entities.Cliente;

public interface IClienteService {

	public Integer insert(Cliente cliente);

	List<Cliente> list();

	public void delete(int id);

	Optional<Cliente> listarId(int idCliente);
}
