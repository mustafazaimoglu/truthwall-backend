package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    Like getByPostIdAndUserId(int postId, int userId);

    List<Like> getByPostId(int postId);

    boolean existsByPostIdAndUserId(int postId, int userId);
}
