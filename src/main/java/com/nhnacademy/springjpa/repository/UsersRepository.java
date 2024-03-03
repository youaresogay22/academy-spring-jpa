package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<users, String> {
    Optional<users> findByUserIdAndUserPassword(String userId, String userPassword);

    long countByUserAuth(String userAuth);

    long countByUserId(String userId);
/*
    Optional<users> findByUserId(String userId);
    int save(users user);
    void updateUserPoint(users user);
    int deleteByUserId(String userId);
    int update(users user);
    int updateLatestLoginAtByUserId(String userId, LocalDateTime latestLoginAt);
 */
}
