package com.codestates.entity_mapping.many_to_many;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("many-to-many-bi")
@EntityScan(basePackageClasses = {JpaManyToManyBiDirectionConfig.class})
@Configuration
public class JpaManyToManyBiDirectionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: many-to-many-bi");

        return args -> {
            mappingManyToManyBiDirection();
        };
    }

    private void mappingManyToManyBiDirection() {
        tx.begin();
        Coffee coffee = new Coffee("카페라떼", "Cafe Lattee", 4000);
        Order order = new Order();
        order.addCoffee(coffee);
        coffee.addOrder(order);

        em.persist(coffee);
        em.persist(order);

        tx.commit();
    }
}

