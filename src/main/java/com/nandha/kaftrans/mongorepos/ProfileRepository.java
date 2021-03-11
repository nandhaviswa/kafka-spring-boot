package com.nandha.kaftrans.mongorepos;

import com.nandha.kaftrans.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
