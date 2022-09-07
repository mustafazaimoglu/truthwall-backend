package dev.mkz.truthwall.service.abstracts;

import dev.mkz.truthwall.model.Dislike;
import dev.mkz.truthwall.util.results.Result;

public interface DislikeService {
    Result dislike(Dislike dislike);

    Result undislike(Dislike dislike);
}
