package pe.edu.upc.donacion.models.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.donacion.models.entities.Donante;

public interface DonanteRepository extends JpaRepository<Donante, Integer> {
	List<Donante> findByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Donante> findByNumeroDocumento(String numeroDocumento) throws Exception;
}
