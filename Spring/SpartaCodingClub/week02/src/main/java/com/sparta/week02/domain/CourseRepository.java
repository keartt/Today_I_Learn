package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
} // Course 에 관한 Repository 생성, JPA Repository 에 있는 Course 의 Long 형태를 상속받는다

