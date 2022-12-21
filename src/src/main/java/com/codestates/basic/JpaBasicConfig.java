package com.codestates.basic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Profile("basic")
@EntityScan(basePackageClasses = {JpaBasicConfig.class})
@Configuration
public class JpaBasicConfig {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaBasicRunner(EntityManagerFactory emFactory) {
        this.emf = emFactory;
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();

        System.out.println("# Active Profile: basic");
        return args -> {
//			example01();
//			example02();
//			example03();
//          example04();
//          example05();
//          analyzePersistContextExpiration();  // 컨텐츠에 없는 참고 코드
// 			persistGeneratedIdentity();         // 컨텐츠에 없는 참고 코드
// 			persistAndCommitGeneratedIdentity(); // 컨텐츠에 없는 참고 코드
        };
    }

    // 영속성 컨텍스트에 엔티티 저장
    private void example01() {
        System.out.println("------------------------------");
        Member member = new Member("hgd@gmail.com");

        /**
         * - commit을 안했으므로, 1차 캐시에 저장되고, 테이블에는 저장이 안된다.
         *
         * @GeneratedValue(strategy = GenerationType.IDENTITY)이므로,
         * Hibernate: call next value for hibernate_sequence 테이블에서 식별자용 시퀀스를 가져와서 1차
         * 캐시에 채운다.
         */
        System.out.println("persist: ------------------------------");
        em.persist(member);


        Member resultMember = em.find(Member.class, 1L);
        System.out.println("Id: " + resultMember.getMemberId() + ", email: " +
                resultMember.getEmail());
        System.out.println("completed: ------------------------------");
    }


    // 영속성 컨텍스트와 테이블에 엔티티 저장
    private void example02() {
        System.out.println(" TX Begin: ------------------------------ ");
        tx.begin();
        Member member = new Member("hgd@gmail.com");

        System.out.println("Persist: ------------------------------ ");
        em.persist(member);

        System.out.println("Commit: ------------------------------ ");
        tx.commit();

        /**
         * - 식별자가 있다. memberId가 1차 캐시에 채워져있다.
         * - 그래서 1차 캐시에서 조회한다.
         * - 쿼리가 실행되지 않는다.
         */
        Member resultMember1 = em.find(Member.class, 1L);

        System.out.println("Find from 1th Cache: ------------------------------ ");
        System.out.println("Id: " + resultMember1.getMemberId() + ", email: " + resultMember1.getEmail());

        System.out.println("Find from DB: ------------------------------ ");
        Member resultMember2 = em.find(Member.class, 2L);
        System.out.println(resultMember2 == null);

    }

    // 쓰기 지연을 통한 영속성 컨텍스트와 테이블에 엔티티 일괄 저장
    private void example03() {
        System.out.println("TX begin: ------------------------------");
        //엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
        tx.begin();
        /**
         * - Strategy AUTO일 경우 코드 작성 순서대로 동작한다.
         * - 그런데 IDENTITY 일 경우는 persist()하면 식별자를 테이블에서 가져와야 하므로, 식별자 없이 1차 캐시에 저장
         * 후, 테이블에 insert한다. (commit 안해도 됨)
         * - insert 후, 식별자를 1차 캐시에 업데이트 한다.
         * - 따라서 쓰기 지연 안됨.
         */
        Member member1 = new Member("hgd1@gmail.com");
        Member member2 = new Member("hgd2@gmail.com");

        System.out.println("persist: ------------------------------");
        em.persist(member1);
        em.persist(member2);

        // GenerationType.AUTO 일 경우, 여기까지 INSERT SQL을 데이터베이스에 보내지 않는다. 쓰기 지연 SQL 저장소에 모아둔다.
        System.out.println("TX commit: ------------------------------");
        tx.commit();
        System.out.println("TX committed: ------------------------------");
    }

    // 영속성 컨텍스트와 테이블에 엔티티 업데이트
    private void example04() {
        System.out.println("TX1 begin: ------------------------------");
        tx.begin();

        System.out.println("Persist: ------------------------------");
        em.persist(new Member("hgd1@gmail.com"));

        System.out.println("TX1 Commit: ------------------------------");
        tx.commit();

        System.out.println("TX2 begin: ------------------------------");
        tx.begin();

        Member member1 = em.find(Member.class, 1L);
        member1.setEmail("hgd1@yahoo.co.kr");

        System.out.println("TX2 commit: ------------------------------");
        tx.commit();
    }

    // 영속성 컨텍스트와 테이블의 엔티티 삭제
    private void example05() {
        System.out.println("TX1 begin: ------------------------------");
        tx.begin();

        System.out.println("Persist: ------------------------------");
        em.persist(new Member("hgd1@gmail.com"));

        System.out.println("TX1 commit: ------------------------------");
        tx.commit();

        System.out.println("TX2 begin: ------------------------------");
        tx.begin();

        Member member = em.find(Member.class, 1L);
        em.remove(member);

        System.out.println("TX2 commit: ------------------------------");
        tx.commit();

    }

    // 컨텐츠에 없는 참고 코드
    private void persistGeneratedIdentity() {
        System.out.println("No TX ---------------------------");
        Member member = new Member("hgd@gmail.com");

        /**
         * - commit을 안했으므로, 1차 캐시에 저장되고, 테이블에는 저장이 안된다.
         * @GeneratedValue(strategy = GenerationType.IDENTITY)이므로,
         * 테이블에 저장하기 전까지는 식별자를 알 수 없다.
         * - memberId가 비어 있는 상태로 저장된다.
         */
        System.out.println("persist: ------------------------------");
        em.persist(member);


        /**
         * - 식별자가 없으므로, memberId는 비어 있다. 따라서 1차 캐시에 원하는 데이터가 없다.
         * - 그래서 테이블에서 조회한다.
         * - 그런데 commit이 아직 되지 않았으므로, 테이블에도 없다.
         */
        Member resultMember = em.find(Member.class, 1L);

        // 따라서 NullPointerException 발생
        System.out.println("Id: " + resultMember.getMemberId() + ", email: " +
                resultMember.getEmail());
    }

    // 컨텐츠에 없는 참고 코드
    private void persistAndCommitGeneratedIdentity() {
        System.out.println(" TX Begin: ------------------------------ ");
        tx.begin();
        Member member = new Member("hgd@gmail.com");

        /**
         * - IDENTITY 전략은 persist() 실행 시, 1차 캐시에 식별자가 없는 상태로 저장.
         * - commit이 없어도 테이블에 저장.
         * - 식별자를 1차 캐시에 업데이트.
         */
        System.out.println("Persist: ------------------------------ ");
        em.persist(member);

        System.out.println("Commit: ------------------------------ ");
        tx.commit();

        /**
         * - 식별자가 있다. memberId가 1차 캐시에 채워져있다.
         * - 그래서 1차 캐시에서 조회한다.
         * - 쿼리가 실행되지 않는다.
         */
        Member resultMember1 = em.find(Member.class, 1L);

        System.out.println("Find from 1th Cache: ------------------------------ ");
        System.out.println("Id: " + resultMember1.getMemberId() + ", email: " + resultMember1.getEmail());

        System.out.println("Find from DB: ------------------------------ ");
        Member resultMember2 = em.find(Member.class, 2L);
        System.out.println(resultMember2 == null);

    }

    // 컨텐츠에 없는 참고 코드
    // tx 범위와 영속성 컨텍스트(EntityManager) 생존 범위가 같다????
    private void analyzePersistContextExpiration() {
        Member member = new Member("hgd@gmail.com");

        EntityManager em = createMember(member);
        System.out.println("find ------------------------------");
        Member resultMember2 = em.find(Member.class, 1L);
        System.out.println("resultMember2: " + resultMember2.getEmail());
    }

    private EntityManager createMember(Member member) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(member);

        tx.commit();
        Member foundMember = em.find(Member.class, member.getMemberId());
        System.out.println("foundMember: " + foundMember.getEmail());
        return em;
    }
}
