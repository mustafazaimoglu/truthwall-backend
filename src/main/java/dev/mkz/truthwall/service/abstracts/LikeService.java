package dev.mkz.truthwall.service.abstracts;

import dev.mkz.truthwall.model.Like;
import dev.mkz.truthwall.util.results.Result;

public interface LikeService {
    Result like(Like like);

    Result unlike(Like like);
}
