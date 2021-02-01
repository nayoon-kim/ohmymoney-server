package com.najinji.ohmymoneyserver.domain.place;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlace is a Querydsl query type for Place
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlace extends EntityPathBase<Place> {

    private static final long serialVersionUID = -1107673082L;

    public static final QPlace place = new QPlace("place");

    public final com.najinji.ohmymoneyserver.domain.QBaseTimeEntity _super = new com.najinji.ohmymoneyserver.domain.QBaseTimeEntity(this);

    public final StringPath address = createString("address");

    public final EnumPath<Category> category = createEnum("category", Category.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath details = createString("details");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final CollectionPath<com.najinji.ohmymoneyserver.domain.picture.Picture, com.najinji.ohmymoneyserver.domain.picture.QPicture> picture = this.<com.najinji.ohmymoneyserver.domain.picture.Picture, com.najinji.ohmymoneyserver.domain.picture.QPicture>createCollection("picture", com.najinji.ohmymoneyserver.domain.picture.Picture.class, com.najinji.ohmymoneyserver.domain.picture.QPicture.class, PathInits.DIRECT2);

    public final StringPath sum = createString("sum");

    public final StringPath tag = createString("tag");

    public final StringPath url = createString("url");

    public QPlace(String variable) {
        super(Place.class, forVariable(variable));
    }

    public QPlace(Path<? extends Place> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlace(PathMetadata metadata) {
        super(Place.class, metadata);
    }

}

