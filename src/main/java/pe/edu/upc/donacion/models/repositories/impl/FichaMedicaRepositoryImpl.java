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

import pe.edu.upc.donacion.models.entities.FichaMedica;
import pe.edu.upc.donacion.models.repositories.FichaMedicaRepository;

@Named
@ApplicationScoped
public class FichaMedicaRepositoryImpl implements FichaMedicaRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "DonacionPU")
	private EntityManager em;

	@Override
	public FichaMedica save(FichaMedica entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public FichaMedica update(FichaMedica entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<FichaMedica> optional = findById(id);
		if (optional.isPresent()) {
			em.remove(optional.get());
		}
	}

	@Override
	public Optional<FichaMedica> findById(Integer id) throws Exception {
		Optional<FichaMedica> optional = Optional.empty();
		String qlString = "SELECT fm FROM FichaMedica fm WHERE  fm.id = ?1";
		TypedQuery<FichaMedica> query = em.createQuery(qlString, FichaMedica.class);
		query.setParameter(1 , id);
		FichaMedica fichaMedica = query.getSingleResult();
		if (fichaMedica != null) {
			optional = Optional.of(fichaMedica);
		}
		return optional;
	}

	@Override
	public List<FichaMedica> findAll() throws Exception {
		List<FichaMedica> fichaMedicas = new ArrayList<>();
		String qlString = "SELECT fm FROM FichaMedica fm";
		TypedQuery<FichaMedica> query = em.createQuery(qlString, FichaMedica.class);
		fichaMedicas = query.getResultList();
		return fichaMedicas;
	}
}
