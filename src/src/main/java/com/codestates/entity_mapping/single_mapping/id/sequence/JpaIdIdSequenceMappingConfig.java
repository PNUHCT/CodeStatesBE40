package com.codestates.entity_mapping.single_mapping.id.sequence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("id-sequence")
@EntityScan(basePackageClasses = {JpaIdIdSequenceMappingConfig.class})
@Configuration
public class JpaIdIdSequenceMappingConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaSingleMappingRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: id-sequence");

        return args -> {
            tx.begin();
            em.persist(new Member());
            Member member = em.find(Member.class, 1L);
            System.out.println("# memberId: " + member.getMemberId());
            tx.commit();

        };
    }
}
