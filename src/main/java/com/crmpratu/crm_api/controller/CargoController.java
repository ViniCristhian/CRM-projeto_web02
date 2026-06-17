package com.crmpratu.crm_api.controller;

import com.crmpratu.crm_api.model.Cargo;
import com.crmpratu.crm_api.repository.CargoRepository;
import com.crmpratu.crm_api.service.CargoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final CargoRepository cargoRepository;
    private final CargoService cargoService;

    public CargoController(CargoRepository cargoRepository, CargoService cargoService) {
        this.cargoRepository = cargoRepository;
        this.cargoService = cargoService;
    }

    @GetMapping("/list")
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @PostMapping
    public Cargo create(@Valid @RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cargo> update(@PathVariable Long id, @Valid @RequestBody Cargo cargo) {
        return ResponseEntity.ok(cargoService.update(id, cargo));
    }
}
