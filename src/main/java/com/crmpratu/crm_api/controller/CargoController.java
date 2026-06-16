package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Cargo;
import com.crmpratu.crm_api.repository.CargoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	private final CargoRepository cargoRepository;

	public CargoController(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@GetMapping("/list")
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	@PostMapping
	public Cargo create(@Valid @RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}

}
