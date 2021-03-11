package com.nandha.kaftrans.mongorepos;

import com.nandha.kaftrans.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
