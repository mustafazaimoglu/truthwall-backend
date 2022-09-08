package dev.mkz.truthwall.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostResponseDTO {
    private int postId;
    private String message;
    private LocalDateTime postDate;
    private int userId;
    private String username;
    private String avatar;
    private int likeCount;
    private int dislikeCount;
    private int userInteraction; // 1 liked 0 no action -1 disliked


    public PostResponseDTO(int postId, String message, LocalDateTime postDate, int userId, String username, String avatar) {
        this.postId = postId;
        this.message = message;
        this.postDate = postDate;
        this.userId = userId;
        this.username = username;
        this.avatar = avatar;
        this.likeCount = 0;
        this.dislikeCount = 0;
        this.userInteraction = 0;
    }
}


