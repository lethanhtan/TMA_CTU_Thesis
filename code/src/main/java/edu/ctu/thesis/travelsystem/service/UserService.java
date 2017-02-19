package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
