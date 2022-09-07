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
}
