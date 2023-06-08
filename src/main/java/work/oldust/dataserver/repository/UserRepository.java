package work.oldust.dataserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import work.oldust.dataserver.entity.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
}
