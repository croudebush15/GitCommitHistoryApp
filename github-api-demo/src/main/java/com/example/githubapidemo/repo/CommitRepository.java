package com.example.githubapidemo.repo;

import com.example.githubapidemo.model.Commit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "commits", path = "commits")
public interface CommitRepository extends MongoRepository<Commit, String> {

}
