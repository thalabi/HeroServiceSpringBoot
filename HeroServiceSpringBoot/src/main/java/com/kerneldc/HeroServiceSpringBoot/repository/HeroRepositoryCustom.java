package com.kerneldc.HeroServiceSpringBoot.repository;

import java.util.List;

import com.kerneldc.HeroServiceSpringBoot.domain.Hero;

public interface HeroRepositoryCustom {

	void merge (Hero hero);
	
	List<Hero> findByNameLikeIgnoreCase (String namePattern);
}
