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

import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.models.repositories.UnidadSangreRepository;

@Named
@ApplicationScoped
public class UnidadSangreRepositoryImpl implements UnidadSangreRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;

	@Override
	public UnidadSangre save(UnidadSangre entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public UnidadSangre update(UnidadSangre entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<UnidadSangre> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<UnidadSangre> findById(Integer id) throws Exception {
		Optional<UnidadSangre> optional = Optional.empty();
		String qlString = "SELECT us FROM UnidadSangre us WHERE  us.id = ?1";
		TypedQuery<UnidadSangre> query = em.createQuery(qlString, UnidadSangre.class);
		query.setParameter(1 , id);
		UnidadSangre unidadSangre = query.getSingleResult();
		if (unidadSangre != null) {
			optional = Optional.of(unidadSangre);
		}
		return optional;
	}

	@Override
	public List<UnidadSangre> findAll() throws Exception {
		List<UnidadSangre> unidadSangres = new ArrayList<>();
		String qlString = "SELECT us FROM UnidadSangre us";
		TypedQuery<UnidadSangre> query = em.createQuery(qlString, UnidadSangre.class);
		unidadSangres = query.getResultList();
		return unidadSangres;
	}

	@Override
	public Optional<UnidadSangre> findByNumeroLote(String numeroLote) throws Exception {
		Optional<UnidadSangre> optional = Optional.empty();
		String qlString = "SELECT us FROM UnidadSangre us WHERE us.numeroLote = ?1";
		TypedQuery<UnidadSangre> query = em.createQuery(qlString, UnidadSangre.class);
		query.setParameter(1, numeroLote);
		UnidadSangre unidadSangre = query.getSingleResult();
		if (unidadSangre != null) {
			optional = Optional.of(unidadSangre);
		}
		return optional;
	}
}
