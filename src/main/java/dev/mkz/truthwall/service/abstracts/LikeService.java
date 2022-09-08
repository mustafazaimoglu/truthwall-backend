package dev.mkz.truthwall.service.abstracts;

import dev.mkz.truthwall.model.Like;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;

import java.util.List;

public interface LikeService {
    Result like(Like like);

    Result unlike(Like like);

    DataResult<List<Like>> getAll();
}
