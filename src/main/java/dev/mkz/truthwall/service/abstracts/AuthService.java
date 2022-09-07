package dev.mkz.truthwall.service.abstracts;

import dev.mkz.truthwall.dto.LoginResponseDTO;
import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;

public interface AuthService {
    DataResult<LoginResponseDTO> login(String username, String password);

    Result register(User user);
}
