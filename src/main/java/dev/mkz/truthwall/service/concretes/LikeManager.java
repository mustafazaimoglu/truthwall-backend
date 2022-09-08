package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.model.Like;
import dev.mkz.truthwall.repository.DislikeRepository;
import dev.mkz.truthwall.repository.LikeRepository;
import dev.mkz.truthwall.service.abstracts.LikeService;
import dev.mkz.truthwall.util.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeManager implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private DislikeRepository dislikeRepository;

    @Override
    public Result like(Like like) {
        if (!dislikeRepository.existsByPostIdAndUserId(like.getPostId(), like.getUserId())) {
            if (!likeRepository.existsByPostIdAndUserId(like.getPostId(), like.getUserId())) {
                this.likeRepository.save(like);
                return new SuccessResult("Post liked successfully!");
            } else {
                return new ErrorResult("Post already liked!");
            }
        } else {
            return new ErrorResult("Post disliked first undislike it!");
        }
    }

    @Override
    public Result unlike(Like like) {
        Like toDelete = this.likeRepository.getByPostIdAndUserId(like.getPostId(), like.getUserId());

        if (toDelete != null) {
            this.likeRepository.delete(toDelete);
            return new SuccessResult("Post unliked successfully!");
        } else {
            return new ErrorResult("Please like the post first!");
        }
    }

    @Override
    public DataResult<List<Like>> getAll() {
        return new SuccessDataResult<>(this.likeRepository.findAll());
    }
}
