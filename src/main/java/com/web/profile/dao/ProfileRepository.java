package com.web.profile.dao;

import com.web.profile.model.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProfileRepository extends ReactiveMongoRepository<Profile, String>{
    Flux<Profile> findAll();
    Mono<Profile> findByNrp(String nrp);
}
