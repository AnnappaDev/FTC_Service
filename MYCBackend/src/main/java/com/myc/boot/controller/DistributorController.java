package com.myc.boot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myc.boot.exceptions.DistributorNotFoundException;
import com.myc.boot.model.Distributor;
import com.myc.boot.repository.DistributorRepository;

@RestController
@RequestMapping(value = "/distributor")
public class DistributorController {
private final DistributorRepository distributorRepository;
	
	
	public DistributorController(DistributorRepository distributorRepository) {
		this.distributorRepository = distributorRepository;
	}


	@GetMapping
	public Iterable<Distributor> getDistributors() {
		return distributorRepository.findAll();
	}	

	@GetMapping("{id}")
	public Distributor getDistributor(@PathVariable Long id) {
		return distributorRepository.findById(id).orElseThrow(DistributorNotFoundException::new);
	}

	@PostMapping
	public Distributor addDistributor(@RequestBody Distributor student) {
		return distributorRepository.save(student);
	}

	@PutMapping("{id}")
	public Distributor updateDistributor(@PathVariable Long id, @RequestBody Distributor retailer) {
		Distributor distributor_a = distributorRepository.findById(id).orElseThrow(DistributorNotFoundException::new);
		distributor_a.setName(retailer.getName());
		distributor_a.setMobileNo(retailer.getMobileNo());
		distributor_a.setEmailId(retailer.getEmailId());
		distributor_a.setShopName(retailer.getShopName());
		distributor_a.setAddress(retailer.getAddress());
		distributor_a.setCity(retailer.getCity());
		distributor_a.setDistrict(retailer.getDistrict());
		distributor_a.setImages("");
		distributor_a.setLocation("");
		distributor_a.setPincode("582119");
		distributor_a.setState(retailer.getState());

		return distributorRepository.save(distributor_a);
	}

	@DeleteMapping("/{id}")
	public void deleteDistributor(@PathVariable Long id) {
		distributorRepository.findById(id).orElseThrow(DistributorNotFoundException::new);
		distributorRepository.deleteById(id);
	}
}
