package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.userpointDetail;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserPointDetailRepositoryCustom {
    Optional<userpointDetail> getOneFromPointDetailId(String pointDetailId);
}
