package com.codestates.entity_mapping.single_mapping.column;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("column")
@EntityScan(basePackageClasses = {JpaColumnMappingConfig.class})
@Configuration
public class JpaColumnMappingConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaSingleMappingRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: column");

        return args -> {
//            testEmailNotNull();
//            testEmailUpdatable();
//            testEmailUnique();
//            testRegisterMember();     // 컨텐츠에는 없는 코드
//            testRegisterCoffee();     // 컨텐츠에는 없는 코드
//            testRegisterOrder();      // 컨텐츠에는 없는 코드
        };
    }

    private void testEmailNotNull() {
        tx.begin();
        em.persist(new Member());
        tx.commit();
    }

    private void testEmailUpdatable() {
        tx.begin();
        em.persist(new Member("hgd@gmail.com"));
        Member member = em.find(Member.class, 1L);
        member.setEmail("hgd@yahoo.co.kr");
        tx.commit();
    }

    private void testEmailUnique() {
        tx.begin();
        em.persist(new Member("hgd@gmail.com"));
        em.persist(new Member("hgd@gmail.com"));
        tx.commit();
    }

    private void testRegisterMember() {
        tx.begin();
        em.persist(new Member("hgd@gmail.com", "hong gil dong", "010-1111-1111"));
        tx.commit();

        Member member = em.find(Member.class, 1L);

        System.out.println("# memberId: " + member.getMemberId() + ", name: " +
                member.getName());
    }

    private void testRegisterCoffee() {
        tx.begin();
        em.persist(new Coffee("아메리카노", "Americano", 2000, "AMC"));
        tx.commit();

        Coffee coffee = em.find(Coffee.class, 1L);

        System.out.println("# coffeeId: " + coffee.getCoffeeId() + ", name: " +
                coffee.getKorName());
    }

    private void testRegisterOrder() {
        tx.begin();
        em.persist(new Order());
        tx.commit();

        Order order = em.find(Order.class, 1L);

        System.out.println("# orderId: " + order.getOrderId() + ", order status: " +
                order.getOrderStatus());
    }
}
