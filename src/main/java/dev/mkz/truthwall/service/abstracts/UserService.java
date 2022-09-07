package dev.mkz.truthwall.service.abstracts;

import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;

public interface UserService {
    Result add(User user);

    Result delete(int id);

    DataResult<User> getByUserId(int userId);

    DataResult<User> getByUsername(String username);
}
