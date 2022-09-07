package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.model.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DislikeRepository extends JpaRepository<Dislike, Integer> {
    Dislike getByPostIdAndUserId(int postId, int userId);

    boolean existsByPostIdAndUserId(int postId, int userId);
}