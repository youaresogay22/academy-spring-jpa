package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.QuserpointDetail;
import com.nhnacademy.springjpa.entity.userpointDetail;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

//#todo: Querydsl
public class UserPointDetailRepositoryImpl extends QuerydslRepositorySupport implements UserPointDetailRepositoryCustom {
    public UserPointDetailRepositoryImpl() {
        super(userpointDetail.class);
    }

    @Override
    public Optional<userpointDetail> getOneFromPointDetailId(String pointDetailId) {
        QuserpointDetail userPointDetail = QuserpointDetail.userpointDetail;
        return Optional.ofNullable(from(userPointDetail)
                .where(userPointDetail.userPointDetailID.eq(pointDetailId))
                .select(userPointDetail).fetchOne());
    }
}
