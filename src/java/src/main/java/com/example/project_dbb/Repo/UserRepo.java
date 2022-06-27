package com.example.project_dbb.Repo;

import com.example.project_dbb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UserRepo extends JpaRepository<User, Long> {
}
