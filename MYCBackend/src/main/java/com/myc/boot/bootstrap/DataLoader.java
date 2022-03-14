package com.myc.boot.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myc.boot.model.Distributor;
import com.myc.boot.model.Retailer;
import com.myc.boot.repository.RetailerRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final RetailerRepository repository;
	
	
	public DataLoader(RetailerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Retailer retailer_a = new Retailer();
		retailer_a.setName("Veeresh Mundevadi");
		retailer_a.setMobileNo("9886887795");
		retailer_a.setEmailId("veereshnm@gmail.com");
		retailer_a.setShopName("Manjunath footwear Main road Naregal");
		retailer_a.setAddress("Main road naregal");
		retailer_a.setCity("naregal");
		retailer_a.setDistrict("Gadag");
		retailer_a.setImages("");
		retailer_a.setLocation("");
		retailer_a.setPincode("582119");
		repository.save(retailer_a);
		
	
	}

}
