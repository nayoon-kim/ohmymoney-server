package com.najinji.ohmymoneyserver.domain.users;

import static com.najinji.ohmymoneyserver.domain.users.QUsers.users;
import org.springframework.stereotype.Repository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UsersQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<Users> findByName(String name) {
        return queryFactory
                .selectFrom(users)
                .where(users.name.eq(name))
                .fetch();
    }
}
