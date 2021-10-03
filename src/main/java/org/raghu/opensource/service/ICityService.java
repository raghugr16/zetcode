package org.raghu.opensource.service;

import java.util.List;

import org.raghu.opensource.entity.City;

public interface ICityService {
	
	City findById(Long id);
	City save(City city);
	List<City> findAll();
}
