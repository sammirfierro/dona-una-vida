package pe.edu.upc.donacion.models.repositories;

import java.util.List;

import pe.edu.upc.donacion.models.entities.TipoSangre;

public interface TipoSangreRepository extends JpaRepository<TipoSangre, Integer> {
	List<TipoSangre> findByNombre(String nombre) throws Exception;
}
