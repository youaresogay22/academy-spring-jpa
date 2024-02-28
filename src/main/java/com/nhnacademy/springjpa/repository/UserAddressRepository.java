package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.useraddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<useraddress, Integer> {
}
