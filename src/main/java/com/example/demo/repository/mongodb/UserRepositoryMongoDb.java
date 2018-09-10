package com.example.demo.repository.mongodb;

import com.example.demo.entity.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryMongoDb extends MongoRepository<User,String> {
    User findByUserName(String username);
}
