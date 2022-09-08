package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.dto.PostResponseDTO;
import dev.mkz.truthwall.dto.PostTemporaryDTO;
import dev.mkz.truthwall.model.Post;
import dev.mkz.truthwall.model.User;
import dev.mkz.truthwall.repository.DislikeRepository;
import dev.mkz.truthwall.repository.LikeRepository;
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

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private DislikeRepository dislikeRepository;

    @Override
    public Result save(PostTemporaryDTO postTemporaryDTO) {
        User user = userRepository.getByUserId(postTemporaryDTO.getUserId());
        Post post = new Post(postTemporaryDTO, user);
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
        List<PostResponseDTO> result = this.postRepository.getAllDto();
        for (PostResponseDTO p : result) {
            p.setLikeCount(likeRepository.getByPostId(p.getPostId()).size());
            p.setDislikeCount(dislikeRepository.getByPostId(p.getPostId()).size());
        }

        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<PostResponseDTO>> getAllDtoUserMode(int userId) {
        List<PostResponseDTO> result = this.postRepository.getAllDto();
        for (PostResponseDTO p : result) {
            p.setLikeCount(likeRepository.getByPostId(p.getPostId()).size());
            p.setDislikeCount(dislikeRepository.getByPostId(p.getPostId()).size());

            int interactionType = 0;
            if (likeRepository.existsByPostIdAndUserId(p.getPostId(), userId)) {
                interactionType = 1;
            }

            if (dislikeRepository.existsByPostIdAndUserId(p.getPostId(), userId)) {
                interactionType = -1;
            }

            p.setUserInteraction(interactionType);
        }

        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<List<PostResponseDTO>> getPostsByUserId(int userId) {
        List<PostResponseDTO> result = this.postRepository.getByUserId(userId);
        for (PostResponseDTO p : result) {
            p.setLikeCount(likeRepository.getByPostId(p.getPostId()).size());
            p.setDislikeCount(dislikeRepository.getByPostId(p.getPostId()).size());
        }

        return new SuccessDataResult<>(result);
    }
}
