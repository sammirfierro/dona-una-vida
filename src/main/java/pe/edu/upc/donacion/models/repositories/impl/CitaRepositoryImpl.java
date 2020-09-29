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

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.repositories.CitaRepository;

@Named
@ApplicationScoped
public class CitaRepositoryImpl implements CitaRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;

	@Override
	public Cita save(Cita entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Cita update(Cita entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Cita> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Cita> findById(Integer id) throws Exception {
		Optional<Cita> optional = Optional.empty();
		String qlString = "SELECT c FROM Cita c WHERE  c.id = ?1";
		TypedQuery<Cita> query = em.createQuery(qlString, Cita.class);
		query.setParameter(1 , id);
		Cita cita = query.getSingleResult();
		if (cita != null) {
			optional = Optional.of(cita);
		}
		return optional;
	}

	@Override
	public List<Cita> findAll() throws Exception {
		List<Cita> citas = new ArrayList<>();
		String qlString = "SELECT c FROM Cita c";
		TypedQuery<Cita> query = em.createQuery(qlString, Cita.class);
		citas = query.getResultList();
		return citas;
	}
}
