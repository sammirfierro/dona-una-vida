package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.Donacion;
import pe.edu.upc.donacion.models.repositories.DonacionRepository;
import pe.edu.upc.donacion.services.DonacionService;

@Named
@ApplicationScoped
public class DonacionServiceImpl implements DonacionService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DonacionRepository donacionRepository;

	@Transactional
	@Override
	public Donacion save(Donacion entity) throws Exception {
		return donacionRepository.save(entity);
	}

	@Transactional
	@Override
	public Donacion update(Donacion entity) throws Exception {
		return donacionRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		donacionRepository.deleteById(id);
	}

	@Override
	public Optional<Donacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return donacionRepository.findById(id);
	}

	@Override
	public List<Donacion> findAll() throws Exception {
		return donacionRepository.findAll();
	}

}
