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

import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.repositories.DonanteRepository;

@Named
@ApplicationScoped
public class DonanteRepositoryImpl implements DonanteRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;
	
	@Override
	public Donante save(Donante entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Donante update(Donante entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Donante> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<Donante> findById(Integer id) throws Exception {
		Optional<Donante> optional = Optional.empty();
		String qlString = "SELECT d FROM Donante d WHERE  d.id = ?1";
		TypedQuery<Donante> query = em.createQuery(qlString, Donante.class);
		query.setParameter(1 , id);
		Donante donante = query.getSingleResult();
		if (donante != null) {
			optional = Optional.of(donante);
		}
		return optional;
	}

	@Override
	public List<Donante> findAll() throws Exception {
		List<Donante> donantes = new ArrayList<>();
		String qlString = "SELECT d FROM Donante d";
		TypedQuery<Donante> query = em.createQuery(qlString, Donante.class);
		donantes = query.getResultList();
		return donantes;
	}

	@Override
	public List<Donante> findByNombresApellidos(String nombresApellidos) throws Exception {
		List<Donante> donantes = new ArrayList<>();
		String qlString = "SELECT d FROM Donante d WHERE d.nombresApellidos LIKE '%?1%'";
		TypedQuery<Donante> query = em.createQuery(qlString, Donante.class);
		query.setParameter(1, nombresApellidos);
		donantes = query.getResultList();
		return donantes;
	}

	@Override
	public Optional<Donante> findByNumeroDocumento(String numeroDocumento) throws Exception {
		Optional<Donante> optional = Optional.empty();
		String qlString = "SELECT d FROM Donante d WHERE d.numeroDocumento = ?1";
		TypedQuery<Donante> query = em.createQuery(qlString, Donante.class);
		query.setParameter(1, numeroDocumento);
		Donante donante = query.getSingleResult();
		if (donante != null) {
			optional = Optional.of(donante);
		}
		return optional;
	}

}
