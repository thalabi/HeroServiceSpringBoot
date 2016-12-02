package com.kerneldc.HeroServiceSpringBoot;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public static void main(String[] args) {
    	
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//        
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
//        System.out.println("beanNames.length: "+beanNames.length);
        logger.info("Application initalized ...");
    }

}
