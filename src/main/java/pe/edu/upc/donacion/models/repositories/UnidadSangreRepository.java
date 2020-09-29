package pe.edu.upc.donacion.models.repositories;

import java.util.Optional;

import pe.edu.upc.donacion.models.entities.UnidadSangre;

public interface UnidadSangreRepository extends JpaRepository<UnidadSangre, Integer> {
	Optional<UnidadSangre> findByNumeroLote(String numeroLote) throws Exception;
}
