package com.zafar.microservices.jpaexample.service;

import com.zafar.microservices.jpaexample.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user) {
        entityManager.persist(user);
        return user.getId();
    }
}
/*
    public class SomeEntityDAOService {

    @PersistenceContext
    private EntityManager entityManager;

        public long insert(SomeEntity entity) {
            entityManager.persist(entity);
            return user.getId();
        }
    }
*/
