package com.zafar.microservices.jpaexample;

import com.zafar.microservices.jpaexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
