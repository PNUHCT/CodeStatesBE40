package com.codestates.entity_mapping.many_to_one_unidirection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("many-to-one-uni")
@EntityScan(basePackageClasses = {JpaManyToOneUniDirectionConfig.class})
@Configuration
public class JpaManyToOneUniDirectionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: many-to-one-uni");

        return args -> {
            mappingManyToOneUniDirection();
        };
    }

    private void mappingManyToOneUniDirection() {
        tx.begin();
        Member member = new Member("hgd@gmail.com", "Hong Gil Dong",
                "010-1111-1111");
        em.persist(member);

        System.out.println("member persisted: ------------------------------");

        Order order = new Order();
        order.addMember(member);
        em.persist(order);

        System.out.println("order persisted: ------------------------------");
        System.out.println("# order equals: " +
                (order == em.find(Order.class, 1L)));

        tx.commit();

        System.out.println("committed: ------------------------------");

        Order findOrder = em.find(Order.class, 1L);

        // 주문한 회원의 회원 정보를 가져올 수 있다.
        System.out.println("findMember: " + findOrder.getMember().getMemberId() +
                        ", " + findOrder.getMember().getEmail());

        /**
         * - 주문한 회원의 주문 정보는 Many To One 관계에서는 가져올 수 없다.
         * - 테이블 관계였으면 가져올텐데..
         * - 이럴 때 양방향 연관 관계를 맺을 수 있다.
         * - 기본적으로 먼저 Many To One으로 관계를 맺는다.
         * - 그리고 나서 원하는 정보를 가져올 수 없다면 One To Many 양방향 관계를 추가한다.
         */
        Member findMember = em.find(Member.class, 1L);

    }
}

