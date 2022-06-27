package com.example.project_dbb.Opportunities;

import com.example.project_dbb.Entity.User;
import com.example.project_dbb.Repo.UserRepo;

import java.util.List;

public class UserOpportunities {

    private final UserRepo userRepo;

    public UserOpportunities(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUserById(long id) {

        return userRepo.findById(id).get();
    }

    public String delUserById(long id) {

        userRepo.deleteById(id);
        return "User was deleted";
    }

    public String addUser(User user) {

        userRepo.save(user);
        return "User was added";
    }

}
