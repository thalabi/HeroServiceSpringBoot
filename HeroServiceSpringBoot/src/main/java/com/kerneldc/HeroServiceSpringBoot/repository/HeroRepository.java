package com.kerneldc.HeroServiceSpringBoot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kerneldc.HeroServiceSpringBoot.domain.Hero;

public interface HeroRepository extends CrudRepository<Hero, Long>, HeroRepositoryCustom {

	@Transactional
	@Modifying
	@Query("update Hero h set h.name = ?2 where h.id = ?1")
	void update(Long id, String name);

	List<Hero> findByName (String name);
	List<Hero> findByNameIgnoreCase (String name);

}
