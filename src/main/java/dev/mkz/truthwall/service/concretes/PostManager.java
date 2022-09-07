package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.dto.PostResponseDTO;
import dev.mkz.truthwall.dto.PostTemporaryDTO;
import dev.mkz.truthwall.model.Post;
import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.repository.PostRepository;
import dev.mkz.truthwall.repository.UserRepository;
import dev.mkz.truthwall.service.abstracts.PostService;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;
import dev.mkz.truthwall.util.results.SuccessDataResult;
import dev.mkz.truthwall.util.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result save(PostTemporaryDTO postTemporaryDTO) {
        User user = userRepository.getByUserId(postTemporaryDTO.getUserId());
        Post post = new Post(postTemporaryDTO,user);
        this.postRepository.save(post);
        return new SuccessResult("Post saved successfully!");
    }

    @Override
    public Result delete(int id) {
        this.postRepository.deleteById(id);
        return new SuccessResult("Post deleted successfully!");
    }

    @Override
    public DataResult<List<Post>> getAll() {
        return new SuccessDataResult<>(this.postRepository.findAll());
    }

    @Override
    public DataResult<List<PostResponseDTO>> getAllDto() {
        return new SuccessDataResult<>(this.postRepository.getAllDto());
    }

    @Override
    public DataResult<List<PostResponseDTO>> getPostsByUserId(int userId) {
       return new SuccessDataResult<>(this.postRepository.getByUserId(userId));
    }
}
