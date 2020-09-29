package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.models.repositories.UnidadSangreRepository;
import pe.edu.upc.donacion.services.UnidadSangreService;

@Named
@ApplicationScoped
public class UnidadSangreServiceImpl implements UnidadSangreService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UnidadSangreRepository unidadSangreRepository;

	@Transactional
	@Override
	public UnidadSangre save(UnidadSangre entity) throws Exception {
		return unidadSangreRepository.save(entity);
	}

	@Transactional
	@Override
	public UnidadSangre update(UnidadSangre entity) throws Exception {
		return unidadSangreRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		unidadSangreRepository.deleteById(id);
	}

	@Override
	public Optional<UnidadSangre> findById(Integer id) throws Exception {
		return unidadSangreRepository.findById(id);
	}

	@Override
	public List<UnidadSangre> findAll() throws Exception {
		return unidadSangreRepository.findAll();
	}

	@Override
	public Optional<UnidadSangre> findByNumeroLote(String numeroLote) throws Exception {
		return unidadSangreRepository.findByNumeroLote(numeroLote);
	}

}
