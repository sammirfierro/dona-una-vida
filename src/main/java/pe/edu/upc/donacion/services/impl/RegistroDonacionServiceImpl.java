package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.RegistroDonacion;
import pe.edu.upc.donacion.models.repositories.RegistroDonacionRepository;
import pe.edu.upc.donacion.services.RegistroDonacionService;

@Named
@ApplicationScoped
public class RegistroDonacionServiceImpl implements RegistroDonacionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RegistroDonacionRepository registroDonacionRepository;

	@Transactional
	@Override
	public RegistroDonacion save(RegistroDonacion entity) throws Exception {
		return registroDonacionRepository.save(entity);
	}

	@Transactional
	@Override
	public RegistroDonacion update(RegistroDonacion entity) throws Exception {
		return registroDonacionRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		registroDonacionRepository.deleteById(id);
	}

	@Override
	public Optional<RegistroDonacion> findById(Integer id) throws Exception {
		return registroDonacionRepository.findById(id);
	}

	@Override
	public List<RegistroDonacion> findAll() throws Exception {
		return registroDonacionRepository.findAll();
	}
}
