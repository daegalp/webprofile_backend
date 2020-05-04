package com.web.profile.service;

import com.web.profile.dao.ProfileRepository;
import com.web.profile.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Flux<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public Mono<Profile> getProfileByNrp(String nrp){
        return profileRepository.findByNrp(nrp);
    }
}
