package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User getByUserId(int userId);

    User getByUsername(String username);
}
