package pe.edu.upc.donacion.models.repositories;

import java.util.List;

import pe.edu.upc.donacion.models.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
	List<Hospital> findByNombre(String nombre) throws Exception;
}
