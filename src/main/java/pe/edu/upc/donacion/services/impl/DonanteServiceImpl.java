package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.repositories.DonanteRepository;
import pe.edu.upc.donacion.services.DonanteService;

@Named
@ApplicationScoped
public class DonanteServiceImpl implements DonanteService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DonanteRepository donanteRepository;

	@Transactional
	@Override
	public Donante save(Donante entity) throws Exception {
		return donanteRepository.save(entity);
	}

	@Transactional
	@Override
	public Donante update(Donante entity) throws Exception {
		return donanteRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		donanteRepository.deleteById(id);
	}

	@Override
	public Optional<Donante> findById(Integer id) throws Exception {
		return donanteRepository.findById(id);
	}

	@Override
	public List<Donante> findAll() throws Exception {
		return donanteRepository.findAll();
	}

	@Override
	public List<Donante> findByNombresApellidos(String nombresApellidos) throws Exception {
		return donanteRepository.findByNombresApellidos(nombresApellidos);
	}

	@Override
	public Optional<Donante> findByNumeroDocumento(String numeroDocumento) throws Exception {
		return donanteRepository.findByNumeroDocumento(numeroDocumento);
	}

}
