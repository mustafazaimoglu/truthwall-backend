package dev.mkz.truthwall.controller;

import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.service.abstracts.UserService;
import dev.mkz.truthwall.util.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getByUsername")
    public DataResult<User> getByUsername(@RequestParam String username) {
        return this.userService.getByUsername(username);
    }

    @GetMapping("getByUserId")
    public DataResult<User> getByUserId(@RequestParam int userId) {
        return this.userService.getByUserId(userId);
    }
}
