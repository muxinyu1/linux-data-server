package work.oldust.dataserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import work.oldust.dataserver.entity.Post;
import work.oldust.dataserver.entity.Response;
import work.oldust.dataserver.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public Response<Post> findById(@PathVariable("id") String id) {
        final var post = postService.findById(id);
        if (post == null) {
            return new Response<>(1, "Post does not exist", null);
        }
        return new Response<>(0, "success", post);
    }

    @PostMapping("/save")
    public Response<Post> save(Post post) {
        if (postService.findById(post.getId()) != null) {
            // 帖子已存在
            return new Response<>(1, "Post has already existed", null);
        }
        return new Response<>(0, "success", postService.save(post));
    }
}
