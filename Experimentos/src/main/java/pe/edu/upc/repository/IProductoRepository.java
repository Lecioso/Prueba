package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query("select p from Producto p")
	List<Producto> list();

}
