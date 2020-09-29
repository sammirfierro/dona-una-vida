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

import pe.edu.upc.donacion.models.entities.RegistroDonacion;
import pe.edu.upc.donacion.models.repositories.RegistroDonacionRepository;

@Named
@ApplicationScoped
public class RegistroDonacionRepositoryImpl implements RegistroDonacionRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;

	@Override
	public RegistroDonacion save(RegistroDonacion entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public RegistroDonacion update(RegistroDonacion entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<RegistroDonacion> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<RegistroDonacion> findById(Integer id) throws Exception {
		Optional<RegistroDonacion> optional = Optional.empty();
		String qlString = "SELECT rd FROM RegistroDonacion rd WHERE  rd.id = ?1";
		TypedQuery<RegistroDonacion> query = em.createQuery(qlString, RegistroDonacion.class);
		query.setParameter(1 , id);
		RegistroDonacion registroDonacion = query.getSingleResult();
		if (registroDonacion != null) {
			optional = Optional.of(registroDonacion);
		}
		return optional;
	}

	@Override
	public List<RegistroDonacion> findAll() throws Exception {
		List<RegistroDonacion> registroDonaciones = new ArrayList<>();
		String qlString = "SELECT rd FROM RegistroDonacion rd";
		TypedQuery<RegistroDonacion> query = em.createQuery(qlString, RegistroDonacion.class);
		registroDonaciones = query.getResultList();
		return registroDonaciones;
	}
}
