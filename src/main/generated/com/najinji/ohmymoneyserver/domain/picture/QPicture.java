package com.najinji.ohmymoneyserver.domain.picture;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPicture is a Querydsl query type for Picture
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPicture extends EntityPathBase<Picture> {

    private static final long serialVersionUID = 727081908L;

    public static final QPicture picture = new QPicture("picture");

    public final com.najinji.ohmymoneyserver.domain.QBaseTimeEntity _super = new com.najinji.ohmymoneyserver.domain.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Long> place_id = createNumber("place_id", Long.class);

    public final StringPath url = createString("url");

    public QPicture(String variable) {
        super(Picture.class, forVariable(variable));
    }

    public QPicture(Path<? extends Picture> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPicture(PathMetadata metadata) {
        super(Picture.class, metadata);
    }

}

