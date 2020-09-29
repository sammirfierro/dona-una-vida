package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.repositories.CitaRepository;
import pe.edu.upc.donacion.services.CitaService;

@Named
@ApplicationScoped
public class CitaServiceImpl implements CitaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CitaRepository citaRepository;

	@Transactional
	@Override
	public Cita save(Cita entity) throws Exception {
		return citaRepository.save(entity);
	}

	@Transactional
	@Override
	public Cita update(Cita entity) throws Exception {
		return citaRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		citaRepository.deleteById(id);
	}

	@Override
	public Optional<Cita> findById(Integer id) throws Exception {
		return citaRepository.findById(id);
	}

	@Override
	public List<Cita> findAll() throws Exception {
		return citaRepository.findAll();
	}

}
