package pe.edu.upc.donacion.models.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.models.repositories.HospitalRepository;

@Named
@ApplicationScoped
public class HospitalRepositoryImpl implements HospitalRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;

	@Override
	public Hospital save(Hospital entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Hospital update(Hospital entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Hospital> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Hospital> findById(Integer id) throws Exception {
		Optional<Hospital> optional = Optional.empty();
		String qlString = "SELECT h FROM Hospital h WHERE  h.id = ?1";
		TypedQuery<Hospital> query = em.createQuery(qlString, Hospital.class);
		query.setParameter(1 , id);
		Hospital hospital = query.getSingleResult();
		if (hospital != null) {
			optional = Optional.of(hospital);
		}
		return optional;
	}

	@Override
	public List<Hospital> findAll() throws Exception {
		List<Hospital> hospitales = new ArrayList<>();
		String qlString = "SELECT h FROM Hospital h";
		TypedQuery<Hospital> query = em.createQuery(qlString, Hospital.class);
		hospitales = query.getResultList();
		return hospitales;
	}

	@Override
	public List<Hospital> findByNombre(String nombre) throws Exception {
		List<Hospital> hospitales = new ArrayList<>();
		String qlString = "SELECT h FROM Hospital h WHERE h.nombre LIKE '%?1%'";
		TypedQuery<Hospital> query = em.createQuery(qlString, Hospital.class);
		query.setParameter(1, nombre);
		hospitales = query.getResultList();
		return hospitales;
	}

}
