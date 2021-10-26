package com.example.websocketproject.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private static UserStorage instance;
    private Set<String> users;

    public UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance() {
        if(instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }


    public Set<String> getUsers() {
        return users;
    }

    public void setUsers(String username) throws Exception {
        if(users.contains(username)) {
            throw new Exception("User already exists with username -> " + username);
        }
        users.add(username);
    }
}
