package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.dto.PostResponseDTO;
import dev.mkz.truthwall.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query("SELECT new dev.mkz.truthwall.dto.PostResponseDTO(p.postId,p.message,p.postDate,p.user.userId,p.user.username,p.user.avatar)" +
            "FROM Post p WHERE p.user.userId=:userId ORDER BY p.postDate DESC")
    List<PostResponseDTO> getByUserId(int userId);

    @Query("SELECT new dev.mkz.truthwall.dto.PostResponseDTO(p.postId,p.message,p.postDate,p.user.userId,p.user.username,p.user.avatar) FROM Post p ORDER BY p.postDate DESC")
    List<PostResponseDTO> getAllDto();
}
