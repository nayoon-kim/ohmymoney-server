package com.najinji.ohmymoneyserver.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@Configuration
public class QuerydslConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}

// 위와 같은 클래스 정의로 프로젝트 어디에서나 JPAQueryFactory를 주입받아 Querydsl을 사용할 수 있게 된다.