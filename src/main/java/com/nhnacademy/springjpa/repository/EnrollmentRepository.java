package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Enrollment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO #2: Enrollment Entity에 대한 Repository interface 정의
public interface EnrollmentRepository extends JpaRepository<Enrollment, Enrollment.Pk> {
    // TODO #3: 학생 이름으로 수강신청 목록을 가져오는 쿼리가 실행되도록 메서드 이름을 정의
    List<Enrollment> findByStudent_Name(String studentName);

    // TODO #4: 강의 이름으로 수강신청 목록을 가져오는 쿼리가 실행되도록 메서드 이름을 정의
    List<Enrollment> findByClazz_Name(String clazzName);

}
