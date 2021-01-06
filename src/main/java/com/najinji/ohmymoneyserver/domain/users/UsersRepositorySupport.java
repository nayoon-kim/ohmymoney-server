package com.najinji.ohmymoneyserver.domain.users;

// class 내부에 선언하지 않고 static으로 import함.
import static com.najinji.ohmymoneyserver.domain.users.QUsers.users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import java.util.List;

@Repository
public class UsersRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public UsersRepositorySupport(JPAQueryFactory queryFactory) {
        super(Users.class);
        this.queryFactory = queryFactory;
    }
    
    // Querydsl의 QClass -> QUsers(users) / build를 하고 나면, 현재 프로젝트에 있는 모든 Entity에 대한 QClass가 생성된다.
    public List<Users> findByName(String name) {
        return queryFactory
                .selectFrom(users)
                .where(users.name.eq(name))
                .fetch();
    }
}
