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

import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.models.repositories.TipoSangreRepository;

@Named
@ApplicationScoped
public class TipoSangreRepositoryImpl implements TipoSangreRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;

	@Override
	public TipoSangre save(TipoSangre entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public TipoSangre update(TipoSangre entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<TipoSangre> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<TipoSangre> findById(Integer id) throws Exception {
		Optional<TipoSangre> optional = Optional.empty();
		String qlString = "SELECT ts FROM TipoSangre ts WHERE  ts.id = ?1";
		TypedQuery<TipoSangre> query = em.createQuery(qlString, TipoSangre.class);
		query.setParameter(1 , id);
		TipoSangre tipoSangre = query.getSingleResult();
		if (tipoSangre != null) {
			optional = Optional.of(tipoSangre);
		}
		return optional;
	}

	@Override
	public List<TipoSangre> findAll() throws Exception {
		List<TipoSangre> tipoSangres = new ArrayList<>();
		String qlString = "SELECT ts FROM TipoSangre ts";
		TypedQuery<TipoSangre> query = em.createQuery(qlString, TipoSangre.class);
		tipoSangres = query.getResultList();
		return tipoSangres;
	}

	@Override
	public List<TipoSangre> findByNombre(String nombre) throws Exception {
		List<TipoSangre> tipoSangres = new ArrayList<>();
		String qlString = "SELECT ts FROM TipoSangre ts WHERE ts.nombre LIKE '%?1%'";
		TypedQuery<TipoSangre> query = em.createQuery(qlString, TipoSangre.class);
		query.setParameter(1, nombre);
		tipoSangres = query.getResultList();
		return tipoSangres;
	}

}
