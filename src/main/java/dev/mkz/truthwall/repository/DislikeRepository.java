package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.model.Dislike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DislikeRepository extends JpaRepository<Dislike, Integer> {
    Dislike getByPostIdAndUserId(int postId, int userId);

    List<Dislike> getByPostId(int postId);

    boolean existsByPostIdAndUserId(int postId, int userId);
}
