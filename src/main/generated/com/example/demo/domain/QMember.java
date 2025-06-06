package com.example.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1886326250L;

    public static final QMember member = new QMember("member1");

    public final com.example.demo.domain.common.QBaseEntity _super = new com.example.demo.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.example.demo.domain.enums.Gender> gender = createEnum("gender", com.example.demo.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<com.example.demo.domain.mapping.MemberAgree, com.example.demo.domain.mapping.QMemberAgree> memberAgreeList = this.<com.example.demo.domain.mapping.MemberAgree, com.example.demo.domain.mapping.QMemberAgree>createList("memberAgreeList", com.example.demo.domain.mapping.MemberAgree.class, com.example.demo.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.domain.mapping.MemberMission, com.example.demo.domain.mapping.QMemberMission> memberMissionList = this.<com.example.demo.domain.mapping.MemberMission, com.example.demo.domain.mapping.QMemberMission>createList("memberMissionList", com.example.demo.domain.mapping.MemberMission.class, com.example.demo.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<com.example.demo.domain.mapping.MemberPrefer, com.example.demo.domain.mapping.QMemberPrefer> memberPreferList = this.<com.example.demo.domain.mapping.MemberPrefer, com.example.demo.domain.mapping.QMemberPrefer>createList("memberPreferList", com.example.demo.domain.mapping.MemberPrefer.class, com.example.demo.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<com.example.demo.domain.enums.SocialType> socialType = createEnum("socialType", com.example.demo.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<com.example.demo.domain.enums.MemberStatus> status = createEnum("status", com.example.demo.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

