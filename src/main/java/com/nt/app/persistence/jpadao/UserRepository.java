package com.nt.app.persistence.jpadao;

import com.nt.app.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findById(Long id);
}
