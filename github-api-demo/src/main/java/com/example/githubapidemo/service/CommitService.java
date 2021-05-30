package com.example.githubapidemo.service;

import com.example.githubapidemo.model.Commit;
import com.example.githubapidemo.model.CommitDeserializer;
import com.example.githubapidemo.repo.CommitRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CommitService {

    @Autowired
    CommitRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    public List<Commit> getAll() {
        return repository.findAll();
    }

    public Boolean getCommitsProject(String url) throws JsonProcessingException {

        ResponseEntity<String> commitResponseEntity = restTemplate.exchange(url,
                HttpMethod.GET, null, String.class);

        if(commitResponseEntity.getStatusCode().is2xxSuccessful()){
            String response = commitResponseEntity.getBody();
            System.out.println(response);

            ObjectMapper mapper = new ObjectMapper();

            SimpleModule module =
                    new SimpleModule("CommitDeserializer", new Version(1, 0, 0, null, null, null));
            module.addDeserializer(Commit.class, new CommitDeserializer());
            mapper.registerModule(module);
            List<Commit> commitResults = mapper.readValue(response, new TypeReference<List<Commit>>(){});

            System.out.println("Generated commit: " + commitResults.toString());
            repository.deleteAll();
            repository.saveAll(commitResults);
            return true;
        } else {
            System.out.println("didnt work");
            return false;
        }
    }


}
