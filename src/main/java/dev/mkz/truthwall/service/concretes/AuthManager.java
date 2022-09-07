package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.dto.LoginResponseDTO;
import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.repository.UserRepository;
import dev.mkz.truthwall.service.abstracts.AuthService;
import dev.mkz.truthwall.service.abstracts.JwtUserDetailsService;
import dev.mkz.truthwall.util.jwt.JwtTokenUtil;
import dev.mkz.truthwall.util.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AuthManager implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DataResult<LoginResponseDTO> login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            return new ErrorDataResult<>(null, "Login Unsuccessful!");
        }

        final User user = userRepository.getByUsername(username);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);

        LoginResponseDTO response = new LoginResponseDTO(user.getUserId(), user.getUsername(), user.getAvatar(), user.getAccountCreationDate(), token);
        return new SuccessDataResult<>(response, "Login Successful!");
    }

    @Override
    public Result register(User user) {
        user.setUsername(user.getUsername().toLowerCase(Locale.ENGLISH));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new SuccessResult("User Registered Successfully");
    }
}
