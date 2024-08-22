package com.springboot.simple.database;

import com.springboot.simple.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DmlTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void getSimple() {
        var var1 = userRepository.findById(1L).get().getName();
        var var2 = userRepository.findAll().get(0).getName();
        assertThat(var1).isEqualTo(var2);
    }
}
