package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Cargo;
import com.crmpratu.crm_api.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
