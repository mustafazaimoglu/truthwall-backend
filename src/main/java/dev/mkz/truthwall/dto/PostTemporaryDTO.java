package dev.mkz.truthwall.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostTemporaryDTO {
    private int postId;
    private String message;
    private int userId;
}
