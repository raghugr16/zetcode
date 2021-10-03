package org.raghu.opensource.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

@Entity
@Table
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "name should not be empty")
	private String name;
	
	@Range(min=10, max=1000000000 , message = "population value should be between 10 to 1000000000")
	private int population;

	public City() {
	}

	public City(@NotEmpty String name, @Range(min = 10, max = 1000000000) int population) {
		super();
		this.name = name;
		this.population = population;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
}
