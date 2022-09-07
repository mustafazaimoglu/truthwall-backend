package dev.mkz.truthwall.controller;

import dev.mkz.truthwall.model.Dislike;
import dev.mkz.truthwall.model.Like;
import dev.mkz.truthwall.service.abstracts.DislikeService;
import dev.mkz.truthwall.service.abstracts.LikeService;
import dev.mkz.truthwall.util.results.ErrorResult;
import dev.mkz.truthwall.util.results.Result;
import dev.mkz.truthwall.util.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/likes-dislikes/")
public class LikeDislikeController {
    @Autowired
    private LikeService likeService;

    @Autowired
    private DislikeService dislikeService;

    @PostMapping("likePost")
    public Result likePost(@RequestParam int postId, @RequestParam int userId) {
        return likeService.like(new Like(postId, userId));
    }

    @PostMapping("unlikePost")
    public Result unlikePost(@RequestParam int postId, @RequestParam int userId) {
        return likeService.unlike(new Like(postId, userId));
    }

    @PostMapping("dislikePost")
    public Result dislikePost(@RequestParam int postId, @RequestParam int userId) {
        return dislikeService.dislike(new Dislike(postId, userId));
    }

    @PostMapping("undislikePost")
    public Result undislikePost(@RequestParam int postId, @RequestParam int userId) {
        return dislikeService.undislike(new Dislike(postId, userId));
    }

    @PostMapping("unlikeAndDislikePost")
    public Result unlikeAndDislikePost(@RequestParam int postId, @RequestParam int userId) {
        Result res1 = likeService.unlike(new Like(postId, userId));
        Result res2 = dislikeService.dislike(new Dislike(postId, userId));

        if (res1.isSuccess() && res2.isSuccess()) {
            return new SuccessResult("Jobs done successfully");
        } else {
            return new ErrorResult("Internal Server Error");
        }
    }

    @PostMapping("undislikeAndLikePost")
    public Result undislikeAndLikePost(@RequestParam int postId, @RequestParam int userId) {
        Result res1 = dislikeService.undislike(new Dislike(postId, userId));
        Result res2 = likeService.like(new Like(postId, userId));

        if (res1.isSuccess() && res2.isSuccess()) {
            return new SuccessResult("Jobs done successfully");
        } else {
            return new ErrorResult("Internal Server Error");
        }
    }
}
