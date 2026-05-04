package com.tdl.SpringBoot.repository;

import com.tdl.SpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // => để cho spring tạo các bean repository
public interface UserRepositorry extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
