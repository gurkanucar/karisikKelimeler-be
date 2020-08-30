package com.gucarsoft.karisikkelimelerbe.repository;

import com.gucarsoft.karisikkelimelerbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByMail(String mail);
}
