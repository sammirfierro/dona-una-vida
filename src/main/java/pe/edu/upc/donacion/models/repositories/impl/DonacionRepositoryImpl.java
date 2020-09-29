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

import pe.edu.upc.donacion.models.entities.Donacion;
import pe.edu.upc.donacion.models.repositories.DonacionRepository;

@Named
@ApplicationScoped
public class DonacionRepositoryImpl implements DonacionRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;
	
	@Override
	public Donacion save(Donacion entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Donacion update(Donacion entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Donacion> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Donacion> findById(Integer id) throws Exception {
		Optional<Donacion> optional = Optional.empty();
		String qlString = "SELECT d FROM Donacion d WHERE  d.id = ?1";
		TypedQuery<Donacion> query = em.createQuery(qlString, Donacion.class);
		query.setParameter(1 , id);
		Donacion donacion = query.getSingleResult();
		if (donacion != null) {
			optional = Optional.of(donacion);
		}
		return optional;
	}

	@Override
	public List<Donacion> findAll() throws Exception {
		List<Donacion> donaciones = new ArrayList<>();
		String qlString = "SELECT d FROM Donacion d";
		TypedQuery<Donacion> query = em.createQuery(qlString, Donacion.class);
		donaciones = query.getResultList();
		return donaciones;
	}

}
