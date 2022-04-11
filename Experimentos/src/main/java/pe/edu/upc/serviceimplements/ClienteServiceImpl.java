package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Cliente;
import pe.edu.upc.repository.IClienteRepository;
import pe.edu.upc.serviceinterface.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional
	public Integer insert(Cliente cliente) {

		int rpta = clienteRepository.buscarCliente(cliente.getNombreCliente());
		if (rpta == 0) {
			clienteRepository.save(cliente);
		}
		return rpta;

	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> list() {

		return clienteRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(int id) {
		clienteRepository.deleteById(id);

	}

	@Override
	public Optional<Cliente> listarId(int idCliente) {

		return clienteRepository.findById(idCliente);
	}

}
