package dev.mkz.truthwall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private int userId;
    private String username;
    private String avatar;
    private LocalDateTime accountCreationDate;
    private String token;
}
