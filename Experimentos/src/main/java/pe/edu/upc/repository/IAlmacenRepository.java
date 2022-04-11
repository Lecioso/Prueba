package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Almacen;

@Repository
public interface IAlmacenRepository extends JpaRepository<Almacen, Integer> {

	@Query("select count(a.nombreAlmacen) from Almacen a where a.nombreAlmacen =:name")
	public int buscarAlmacen(@Param("name") String nombreAlmacen);

}
