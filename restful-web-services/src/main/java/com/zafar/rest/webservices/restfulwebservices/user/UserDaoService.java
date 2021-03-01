package com.zafar.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    public static List<User> users = new ArrayList<>();

    private static int usersCount = 4;

    static {
        users.add(new User(1, "2020-12-22T06:52:34.793+00:00", "kala"));
        users.add(new User(1, "2020-12-22T06:52:34.793+00:00", "bala"));
        users.add(new User(1, "2020-12-22T06:52:34.793+00:00", "mala"));
        users.add(new User(1, "2020-12-22T06:52:34.793+00:00", "sala"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId()==null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for(User user:users) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User deleteOne(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User user;
            user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
