package com.kerneldc.HeroServiceSpringBoot.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kerneldc.HeroServiceSpringBoot.domain.Hero;
import com.kerneldc.HeroServiceSpringBoot.repository.HeroRepository;

@Component
@Path("/HeroService/hero")
public class HeroResource {

	private static final Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

	//@Autowired
	//private Service service;

	@Autowired
	private HeroRepository heroRepository;

	@GET
	public String message() {
		
		logger.debug("heroRepository.someCustomMethod(\"%z%\").size(): {}", heroRepository.findByNameLikeIgnoreCase("%Z%").size());
		
		return "Hello " +
				", heroDao.count(): " + heroRepository.count();
	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<Hero> getHeroList() {
		
		logger.debug("begin ...");
		logger.debug("end ...");
		return heroRepository.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hero findHero(
		@PathParam("id") long id) {

		logger.debug("begin ...");
		
		logger.debug("end ...");
		return heroRepository.findOne(id);
		
	}

	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hero findHeroByName(
		@PathParam("name") String name) {

		logger.debug("begin ...");
		
		logger.debug("end ...");
		return heroRepository.findByNameIgnoreCase(name).get(0);
		
	}
	
	// curl -H "Content-Type: application/json" -X POST -d '{"name":"xyz"}' http://localhost:8080/HeroService/hero
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Hero saveHero(
    	Hero hero) {

    	logger.debug("begin ...");
    	heroRepository.save(hero);
		logger.debug("end ...");
		return hero;
    }

    // curl -i -H "Content-Type: application/json" -X DELETE  http://localhost:8080/HeroService/hero/1
    @DELETE
    @Path("{id}")
    public Hero deleteHero(
    	@PathParam("id") long id) {
        
    	logger.debug("begin ...");
    	heroRepository.delete(id);
		logger.debug("end ...");
    	return null;
    }

    // curl -i -H "Content-Type: application/json" -X PUT -d '{"id":4,"name":"new name"}' http://localhost:8080/HeroService/hero
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Hero updateHero(
    	Hero transientHero) {

    	logger.debug("begin ...");
//    	Hero persistentHero = heroRepository.findOne(transientHero.getId());
//    	logger.debug("persistentHero before setting properties: {}", persistentHero);
//    	persistentHero.setName(transientHero.getName());
//    	logger.debug("persistentHero after setting properties: {}", persistentHero);
//    	Hero detachedHero = heroRepository.save(persistentHero);
//    	Hero detachedHero = heroRepository.save(transientHero);
    	logger.debug("transientHero before setting properties: {}", transientHero);
    	//heroRepository.update(transientHero.getId(), transientHero.getName());
    	heroRepository.merge(transientHero);
    	
    	logger.debug("end ...");
		//return detachedHero;
		//return persistentHero;
    	return transientHero;
    }

}
