package com.myc.boot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myc.boot.exceptions.RetailerNotFoundException;
import com.myc.boot.model.Retailer;
import com.myc.boot.repository.RetailerRepository;

@RestController
@RequestMapping(value = "/retailer")
public class RetailerController {

	private final RetailerRepository retailerRepository;
	
	
	public RetailerController(RetailerRepository retailerRepository) {
		this.retailerRepository = retailerRepository;
	}


	@GetMapping
	public Iterable<Retailer> getRetailers() {
		return retailerRepository.findAll();
	}	

	@GetMapping("{id}")
	public Retailer getRetailer(@PathVariable Long id) {
		return retailerRepository.findById(id).orElseThrow(RetailerNotFoundException::new);
	}

	@PostMapping
	public Retailer addRetailer(@RequestBody Retailer student) {
		return retailerRepository.save(student);
	}

	@PutMapping("{id}")
	public Retailer updateRetailer(@PathVariable Long id, @RequestBody Retailer retailer) {
		Retailer retailer_a = retailerRepository.findById(id).orElseThrow(RetailerNotFoundException::new);
		retailer_a.setName(retailer.getName());
		retailer_a.setMobileNo(retailer.getMobileNo());
		retailer_a.setEmailId(retailer.getEmailId());
		retailer_a.setShopName(retailer.getShopName());
		retailer_a.setAddress(retailer.getAddress());
		retailer_a.setCity(retailer.getCity());
		retailer_a.setDistrict(retailer.getDistrict());
		retailer_a.setImages("");
		retailer_a.setLocation("");
		retailer_a.setPincode("582119");
		retailer_a.setState(retailer.getState());

		return retailerRepository.save(retailer_a);
	}

	@DeleteMapping("/{id}")
	public void deleteRetailer(@PathVariable Long id) {
		retailerRepository.findById(id).orElseThrow(RetailerNotFoundException::new);
		retailerRepository.deleteById(id);
	}
}
