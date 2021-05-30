package com.example.githubapidemo.resource;

import com.example.githubapidemo.service.CommitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommitResource {

    @Autowired
    CommitService service;

    @GetMapping("/commits/{user}/{project}")
    public ResponseEntity getProject(@PathVariable String user, @PathVariable String project) throws JsonProcessingException {

        String url = "https://api.github.com/repos/" + user + "/" + project + "/commits";

        if (!service.getCommitsProject(url)) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
