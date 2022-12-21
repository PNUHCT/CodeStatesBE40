package com.codestates.entity_mapping.one_to_many_unidirection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("one-to-many-uni")
@EntityScan(basePackageClasses = {JpaOneToManyUniDirectionConfig.class})
@Configuration
public class JpaOneToManyUniDirectionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: one-to-many-uni");

        return args -> {
            mappingOneToManyUniDirection();
        };
    }

    private void mappingOneToManyUniDirection() {
        tx.begin();
        Member member = new Member("hgd@gmail.com", "Hong Gil Dong",
                "010-1111-1111");
        Order order1 = new Order();
        Order order2 = new Order();

        member.addOrder(order1);
        member.addOrder(order2);

        em.persist(member);

        // Order는 Member를 모르는 상태
        em.persist(order1);
        em.persist(order2);

        tx.commit();

    }
}

