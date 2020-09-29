package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.FichaMedica;
import pe.edu.upc.donacion.models.repositories.FichaMedicaRepository;
import pe.edu.upc.donacion.services.FichaMedicaService;

@Named
@ApplicationScoped
public class FichaMedicaServiceImpl implements FichaMedicaService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FichaMedicaRepository fichaMedicaRepository;

	@Transactional
	@Override
	public FichaMedica save(FichaMedica entity) throws Exception {
		return fichaMedicaRepository.save(entity);
	}

	@Transactional
	@Override
	public FichaMedica update(FichaMedica entity) throws Exception {
		return fichaMedicaRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		fichaMedicaRepository.deleteById(id);
	}

	@Override
	public Optional<FichaMedica> findById(Integer id) throws Exception {
		return fichaMedicaRepository.findById(id);
	}

	@Override
	public List<FichaMedica> findAll() throws Exception {
		return fichaMedicaRepository.findAll();
	}

}
