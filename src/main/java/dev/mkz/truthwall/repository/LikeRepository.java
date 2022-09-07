package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    Like getByPostIdAndUserId(int postId, int userId);

    boolean existsByPostIdAndUserId(int postId, int userId);
}
