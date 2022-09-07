package dev.mkz.truthwall.service.abstracts;

import dev.mkz.truthwall.dto.PostResponseDTO;
import dev.mkz.truthwall.dto.PostTemporaryDTO;
import dev.mkz.truthwall.model.Post;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;

import java.util.List;

public interface PostService {
    Result save(PostTemporaryDTO postTemporaryDTO);

    Result delete(int id);

    DataResult<List<Post>> getAll();

    DataResult<List<PostResponseDTO>> getAllDto();

    DataResult<List<PostResponseDTO>> getPostsByUserId(int userId);
}
