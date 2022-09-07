package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.repository.UserRepository;
import dev.mkz.truthwall.service.abstracts.UserService;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;
import dev.mkz.truthwall.util.results.SuccessDataResult;
import dev.mkz.truthwall.util.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User added successfully!");
    }

    @Override
    public Result delete(int id) {
        this.userRepository.deleteById(id);
        return new SuccessResult("User deleted successfully!");
    }

    @Override
    public DataResult<User> getByUserId(int userId) {
        return new SuccessDataResult<>(this.userRepository.getByUserId(userId),"User Found!");
    }

    @Override
    public DataResult<User> getByUsername(String username) {
        return new SuccessDataResult<>(this.userRepository.getByUsername(username),"User Found!");

    }
}
