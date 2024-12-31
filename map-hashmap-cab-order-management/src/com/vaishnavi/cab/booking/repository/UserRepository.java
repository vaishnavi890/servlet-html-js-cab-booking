package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return userMap.get(userId);
    }

    public void removeUser(String userId) {
        userMap.remove(userId);
    }

    public boolean containsUser(String userId) {
        return userMap.containsKey(userId);
    }

    public boolean containsUserByName(String name) {
        return userMap.values().stream().anyMatch(user -> user.getName().equalsIgnoreCase(name));
    }

    public int getUserCount() {
        return userMap.size();
    }

    public void displayAllUsers() {
        userMap.entrySet().forEach(entry ->
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
    }
}

