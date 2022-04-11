package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("select count(c.nombreCliente) from Cliente c where c.nombreCliente =:name")
	public int buscarCliente(@Param("name") String nombreCliente);
}
