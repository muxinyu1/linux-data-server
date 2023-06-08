package work.oldust.dataserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import work.oldust.dataserver.entity.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
