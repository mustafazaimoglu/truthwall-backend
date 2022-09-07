package dev.mkz.truthwall.controller;

import dev.mkz.truthwall.dto.LoginRequestDTO;
import dev.mkz.truthwall.dto.LoginResponseDTO;
import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.service.abstracts.AuthService;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public DataResult<LoginResponseDTO> userLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
        return this.authService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
    }

    @PostMapping("register")
    public Result userRegister(@RequestBody User user) {
        return this.authService.register(user);
    }
}
