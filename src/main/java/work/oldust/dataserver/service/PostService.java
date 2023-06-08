package work.oldust.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.oldust.dataserver.entity.Post;
import work.oldust.dataserver.repository.PostRepository;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
