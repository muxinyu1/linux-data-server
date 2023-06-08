package work.oldust.dataserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import work.oldust.dataserver.entity.Post;

public interface PostRepository extends MongoRepository<Post, String>{
    
}
