package dev.mkz.truthwall.repository;

import dev.mkz.truthwall.dto.PostResponseDTO;
import dev.mkz.truthwall.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT new dev.mkz.truthwall.dto.PostResponseDTO(p.postId,p.message,p.postDate,p.user.userId,p.user.username,p.user.avatar)" +
            "FROM Post p WHERE p.user.userId=:userId ORDER BY p.postDate DESC")
    List<PostResponseDTO> getByUserId(int userId);

    @Query("SELECT new dev.mkz.truthwall.dto.PostResponseDTO(p.postId,p.message,p.postDate,p.user.userId,p.user.username,p.user.avatar) FROM Post p ORDER BY p.postDate DESC")
    List<PostResponseDTO> getAllDto();

//    @Query("SELECT new dev.mkz.truthwall.dto.PostResponseDTO(p.postId,p.message,p.postDate,p.user.userId,p.user.username,p.user.avatar,COUNT(DISTINCT l.userId),COUNT(DISTINCT d.userId))" +
//            "FROM Post p LEFT JOIN Like l ON l.postId = p.postId LEFT JOIN Dislike d ON d.postId = p.postId GROUP BY p.postId ORDER BY p.postDate DESC")
//    List<PostResponseDTO> getAllDto();

//    @Query("SELECT new dev.mkz.truthwall.dto.PostResponseDTO(p.postId,p.message,p.postDate,p.user.userId,p.user.username,p.user.avatar,j1.likeCount,j2.dislikeCount) FROM Post p " +
//            "LEFT JOIN (SELECT postId,SUM(l.postId) as likeCount FROM Like l GROUP BY l.postId) j1 ON j1.postId = p.postId " +
//            "LEFT JOIN (SELECT postId,SUM(d.postId) as dislikeCount FROM Dislike d GROUP BY d.postId) j2 ON j2.postId = p.postId " +
//            "ORDER BY p.postDate DESC")
//    List<PostResponseDTO> getAllDto();
}
