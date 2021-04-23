package com.schedulingproject.project.user.repository;

import com.schedulingproject.project.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
