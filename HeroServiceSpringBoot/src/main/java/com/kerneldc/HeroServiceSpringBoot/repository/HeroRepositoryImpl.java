package com.kerneldc.HeroServiceSpringBoot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;

import com.kerneldc.HeroServiceSpringBoot.domain.Hero;
import com.kerneldc.HeroServiceSpringBoot.domain.Hero_;

public class HeroRepositoryImpl implements HeroRepositoryCustom {

	private static final Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	@Autowired
	private JpaContext jpaContext;
	
	@Override
	@Transactional
	public void merge (
		Hero hero) {
		
		EntityManager entityManager = jpaContext.getEntityManagerByManagedType(Hero.class);
		entityManager.merge(hero);
	}
	@Override
	public List<Hero> findByNameLikeIgnoreCase (
		String namePattern) {
		
		logger.debug("begin ...");
		
		EntityManager entityManager = jpaContext.getEntityManagerByManagedType(Hero.class);
    	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    	
		CriteriaQuery<Hero> query = builder.createQuery(Hero.class);
		Root<Hero> from = query.from(Hero.class);

		//from.fetch(User_.groupSet).fetch(Group_.permissionSet);
		
		query.select(from);
		
		ParameterExpression<String> nameParameter = builder.parameter(String.class, Hero_.name.getName());
		//query.where(builder.equal(from.get(Hero_.name), nameParameter));
		query.where(builder.like(builder.lower(from.get(Hero_.name)), builder.lower(nameParameter)));
		
		logger.debug("end ...");
		return entityManager.createQuery(query).setParameter(Hero_.name.getName(), namePattern).getResultList();

	}

}
