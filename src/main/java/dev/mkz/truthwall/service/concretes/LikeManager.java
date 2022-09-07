package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.model.Dislike;
import dev.mkz.truthwall.model.Like;
import dev.mkz.truthwall.repository.LikeRepository;
import dev.mkz.truthwall.service.abstracts.LikeService;
import dev.mkz.truthwall.util.results.ErrorResult;
import dev.mkz.truthwall.util.results.Result;
import dev.mkz.truthwall.util.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeManager implements LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Result like(Like like) {
        if (!likeRepository.existsByPostIdAndUserId(like.getPostId(),like.getUserId())) {
            this.likeRepository.save(like);
            return new SuccessResult("Post liked successfully!");
        } else {
            return new ErrorResult("Post already liked!");
        }
    }

    @Override
    public Result unlike(Like like) {
        Like toDelete = this.likeRepository.getByPostIdAndUserId(like.getPostId(),like.getUserId());

        if (toDelete != null) {
            this.likeRepository.delete(toDelete);
            return new SuccessResult("Post unliked successfully!");
        } else {
            return new ErrorResult("Please like the post first!");
        }
    }
}
