package com.sparta.week04.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
} // JpaRepository 기능을 사용할 것이므로 상속 / Product 를 Long 형태로