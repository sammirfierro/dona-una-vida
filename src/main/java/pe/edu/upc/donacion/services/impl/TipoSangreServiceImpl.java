package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.models.repositories.TipoSangreRepository;
import pe.edu.upc.donacion.services.TipoSangreService;

@Named
@ApplicationScoped
public class TipoSangreServiceImpl implements TipoSangreService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoSangreRepository tipoSangreRepository;

	@Transactional
	@Override
	public TipoSangre save(TipoSangre entity) throws Exception {
		return tipoSangreRepository.save(entity);
	}

	@Transactional
	@Override
	public TipoSangre update(TipoSangre entity) throws Exception {
		return tipoSangreRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tipoSangreRepository.deleteById(id);
	}

	@Override
	public Optional<TipoSangre> findById(Integer id) throws Exception {
		return tipoSangreRepository.findById(id);
	}

	@Override
	public List<TipoSangre> findAll() throws Exception {
		return tipoSangreRepository.findAll();
	}

	@Override
	public List<TipoSangre> findByNombre(String nombre) throws Exception {
		return tipoSangreRepository.findByNombre(nombre);
	}

}
