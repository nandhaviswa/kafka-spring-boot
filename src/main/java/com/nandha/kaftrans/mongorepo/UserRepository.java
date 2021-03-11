package com.nandha.kaftrans.mongorepo;

import com.nandha.kaftrans.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
