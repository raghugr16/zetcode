package org.raghu.opensource.service;

import java.util.List;

import org.raghu.opensource.entity.City;
import org.raghu.opensource.entity.CityRepository;
import org.raghu.opensource.exception.CityNotFoundException;
import org.raghu.opensource.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService{

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public City findById(Long id) {
		return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public List<City> findAll() {
		List<City> cities = (List<City>) cityRepository.findAll();
		if(cities == null ) {
			throw new NoDataFoundException("No Data Found");
		}
		if(cities.isEmpty()) {
			throw new NoDataFoundException("No Data Found");
		}
		return cities;
	}
	
	

}
