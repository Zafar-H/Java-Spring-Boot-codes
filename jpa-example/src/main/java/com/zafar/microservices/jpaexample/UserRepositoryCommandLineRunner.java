package com.zafar.microservices.jpaexample;

import com.zafar.microservices.jpaexample.entity.User;
import com.zafar.microservices.jpaexample.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws  Exception {
        User user = new User("Manoj", "Admin");
        userRepository.save(user);
        log.info("New user is created : " + user);
    }
}
