package com.example.githubapidemo.resource;

import com.example.githubapidemo.model.Commit;
import com.example.githubapidemo.service.CommitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
public class CommitResource {

    @Autowired
    CommitService service;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/commits/{user}/{project}")
    public ResponseEntity getProject(@PathVariable String user, @PathVariable String project) throws JsonProcessingException {

        String url = "https://api.github.com/repos/" + user + "/" + project + "/commits";

        if (!service.getCommitsProject(url)) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/commits")
    public ResponseEntity getCommits() {

        List<Commit> commitList = service.getAll();

        if (commitList == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(commitList, HttpStatus.OK);
    }
}
