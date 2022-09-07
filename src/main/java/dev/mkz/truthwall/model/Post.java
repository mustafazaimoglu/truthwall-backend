package dev.mkz.truthwall.model;

import dev.mkz.truthwall.dto.PostTemporaryDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "post_date")
    private LocalDateTime postDate = LocalDateTime.now();

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public Post(PostTemporaryDTO postTemporaryDTO, User user) {
        this.postId = postTemporaryDTO.getPostId();
        this.message = postTemporaryDTO.getMessage();
        this.user = user;
    }
}
