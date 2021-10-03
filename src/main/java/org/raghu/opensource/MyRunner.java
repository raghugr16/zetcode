package org.raghu.opensource;


import org.raghu.opensource.entity.City;
import org.raghu.opensource.entity.CityRepository;
import org.raghu.opensource.service.ICityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ICityService icityService;
	
	@Override
	public void run(String... args) throws Exception {
		logger.debug("Save Cities");
		saveCity();
	}
	
	public void saveCity() {
		cityRepository.deleteAll();
		icityService.save(new City("Bratislava", 432000));
		icityService.save(new City("Budapest", 1759000));
		icityService.save(new City("Prague", 1280000));
		icityService.save(new City("Warsaw", 1748000));
		icityService.save(new City("Los Angeles", 3971000));
		icityService.save(new City("New York", 8550000));
		icityService.save(new City("Edinburgh", 464000));
		icityService.save(new City("Suzhou", 4327066));
		icityService.save(new City("Zhengzhou", 4122087));
		icityService.save(new City("Berlin", 3671000));
	}
}
