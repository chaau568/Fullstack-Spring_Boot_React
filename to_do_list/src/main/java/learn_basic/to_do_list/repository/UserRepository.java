package learn_basic.to_do_list.repository;

import org.springframework.stereotype.Repository;
import learn_basic.to_do_list.entity.UserEntity;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository 
public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
}
