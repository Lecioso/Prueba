package pe.edu.upc.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entities.Almacen;
import pe.edu.upc.repository.IAlmacenRepository;
import pe.edu.upc.serviceinterface.IAlmacenService;

@Service
public class AlmacenServiceImpl implements IAlmacenService {

	@Autowired
	private IAlmacenRepository almacenRepository;

	@Override
	@Transactional
	public Integer insert(Almacen almacen) {

		int rpta = almacenRepository.buscarAlmacen(almacen.getNombreAlmacen());
		if (rpta == 0) {
			almacenRepository.save(almacen);
		}

		return rpta;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Almacen> list() {

		return almacenRepository.findAll();
	}

	@Override
	@Transactional
	public void delete(int id) {
		almacenRepository.deleteById(id);

	}

	@Override
	public Optional<Almacen> listarId(int idAlmacen) {

		return almacenRepository.findById(idAlmacen);
	}

}
