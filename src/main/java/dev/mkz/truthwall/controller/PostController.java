package dev.mkz.truthwall.controller;

import dev.mkz.truthwall.dto.PostResponseDTO;
import dev.mkz.truthwall.dto.PostTemporaryDTO;
import dev.mkz.truthwall.model.Post;
import dev.mkz.truthwall.service.abstracts.PostService;
import dev.mkz.truthwall.util.results.DataResult;
import dev.mkz.truthwall.util.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/posts/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("save")
    public Result save(@RequestBody PostTemporaryDTO postTemporaryDTO) {
        return this.postService.save(postTemporaryDTO);
    }

    @PostMapping("delete")
    public Result delete(@RequestParam int id) {
        return this.postService.delete(id);
    }

    @GetMapping("getAll")
    public DataResult<List<Post>> getAll() {
        return this.postService.getAll();
    }

    @GetMapping("getAllDto")
    public DataResult<List<PostResponseDTO>> getAllDto() {
        return this.postService.getAllDto();
    }

    @GetMapping("getAllDtoUserMode")
    public DataResult<List<PostResponseDTO>> getAllDtoUserMode(@RequestParam int userId) {
        return this.postService.getAllDtoUserMode(userId);
    }

    @GetMapping("getPostsByUserId")
    public DataResult<List<PostResponseDTO>> getPostsByUserId(@RequestParam int userId) {
        return this.postService.getPostsByUserId(userId);
    }
}
