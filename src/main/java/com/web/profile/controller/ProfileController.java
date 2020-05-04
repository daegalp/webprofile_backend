package com.web.profile.controller;

import com.web.profile.model.Profile;
import com.web.profile.model.constant.ApiPath;
import com.web.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
@CrossOrigin
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping(value = ApiPath.GET_PROFILES,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<List<Profile>> getProfiles() {
        return profileService.getProfiles()
                .collectList()
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(value = ApiPath.GET_PROFILE_BY_NRP,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Profile> getProfileByNrp(@PathVariable String nrp) {
        return profileService.getProfileByNrp(nrp)
                .subscribeOn(Schedulers.elastic());
    }
}
