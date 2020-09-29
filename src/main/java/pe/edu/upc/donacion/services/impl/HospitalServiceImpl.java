package pe.edu.upc.donacion.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.models.repositories.HospitalRepository;
import pe.edu.upc.donacion.services.HospitalService;

@Named
@ApplicationScoped
public class HospitalServiceImpl implements HospitalService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HospitalRepository hospitalRepository;

	@Transactional
	@Override
	public Hospital save(Hospital entity) throws Exception {
		return hospitalRepository.save(entity);
	}

	@Transactional
	@Override
	public Hospital update(Hospital entity) throws Exception {
		return hospitalRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		hospitalRepository.deleteById(id);
	}

	@Override
	public Optional<Hospital> findById(Integer id) throws Exception {
		return hospitalRepository.findById(id);
	}

	@Override
	public List<Hospital> findAll() throws Exception {
		return hospitalRepository.findAll();
	}

	@Override
	public List<Hospital> findByNombre(String nombre) throws Exception {
		return hospitalRepository.findByNombre(nombre);
	}

}
