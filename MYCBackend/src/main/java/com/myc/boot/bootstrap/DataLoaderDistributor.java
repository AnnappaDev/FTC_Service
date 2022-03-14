package com.myc.boot.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myc.boot.model.Distributor;
import com.myc.boot.repository.DistributorRepository;

@Component
public class DataLoaderDistributor  implements ApplicationListener<ContextRefreshedEvent> {
private final DistributorRepository repository;
	
	
	public DataLoaderDistributor(DistributorRepository repository) {
		this.repository = repository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Distributor distributor_a = new Distributor();
		distributor_a.setName("Ramdev");
		distributor_a.setMobileNo("9886457795");
		distributor_a.setEmailId("ramdev@gmail.com");
		distributor_a.setShopName("Ramdeva Distributor");
		distributor_a.setAddress("Station main raod");
		distributor_a.setCity("Gadag");
		distributor_a.setDistrict("Gadag");
		distributor_a.setImages("");
		distributor_a.setLocation("");
		distributor_a.setPincode("582100");
		repository.save(distributor_a);
		
	
	}
}
