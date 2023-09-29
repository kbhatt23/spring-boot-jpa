package com.learning.springliquibasesampleapp.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springliquibasesampleapp.profile.ProfileRepository;

@RestController
@RequestMapping(value = "/api/profiles")
public class SearchProfilesController {

	private final ProfileRepository profileRepository;

	@Autowired
	private SearchProfilesController(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfileDto>> getMainPage() {
		List<ProfileDto> profileList = profileRepository.findAll().stream().map(ProfileDto::from)
				.collect(Collectors.toList());
		return ResponseEntity.ok(profileList);
	}

}
