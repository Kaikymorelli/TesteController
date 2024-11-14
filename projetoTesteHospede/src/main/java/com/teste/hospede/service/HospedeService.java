package com.teste.hospede.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.hospede.entity.Hospede;
import com.teste.hospede.repository.HospedeRepository;

@Service
public class HospedeService {

	private final HospedeRepository hospedeRepository;

	@Autowired
	public HospedeService(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}

	public List<Hospede> getAllhospede() {
		return hospedeRepository.findAll();
	}

	public Hospede gethospedeById(Long id) {
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		return hospede.orElse(null);
	}

	public Hospede salvarhospede(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	public Hospede updatehospede(Long id, Hospede updatedhospede) {
		Optional<Hospede> existinghospede = hospedeRepository.findById(id);
		if (existinghospede.isPresent()) {
			updatedhospede.setId(id);
			return hospedeRepository.save(updatedhospede);
		}
		return null;
	}

	public boolean deletehospede(Long id) {
		Optional<Hospede> existinghospede = hospedeRepository.findById(id);
		if (existinghospede.isPresent()) {
			hospedeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
