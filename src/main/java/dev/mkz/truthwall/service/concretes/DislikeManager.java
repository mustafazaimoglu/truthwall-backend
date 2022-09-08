package dev.mkz.truthwall.service.concretes;

import dev.mkz.truthwall.model.Dislike;
import dev.mkz.truthwall.repository.DislikeRepository;
import dev.mkz.truthwall.repository.LikeRepository;
import dev.mkz.truthwall.service.abstracts.DislikeService;
import dev.mkz.truthwall.util.results.ErrorResult;
import dev.mkz.truthwall.util.results.Result;
import dev.mkz.truthwall.util.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DislikeManager implements DislikeService {
    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Result dislike(Dislike dislike) {
        if (!likeRepository.existsByPostIdAndUserId(dislike.getPostId(), dislike.getUserId())) {
            if (!dislikeRepository.existsByPostIdAndUserId(dislike.getPostId(), dislike.getUserId())) {
                this.dislikeRepository.save(dislike);
                return new SuccessResult("Post disliked successfully!");
            } else {
                return new ErrorResult("Post already disliked!");
            }
        } else {
            return new ErrorResult("Post liked first unlike it!");
        }
    }

    @Override
    public Result undislike(Dislike dislike) {
        Dislike toDelete = this.dislikeRepository.getByPostIdAndUserId(dislike.getPostId(), dislike.getUserId());

        if (toDelete != null) {
            this.dislikeRepository.delete(toDelete);
            return new SuccessResult("Post undisliked successfully!");
        } else {
            return new ErrorResult("Please dislike the post first!");
        }
    }
}
