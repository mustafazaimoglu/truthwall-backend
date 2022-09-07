package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like,Integer> {
}
