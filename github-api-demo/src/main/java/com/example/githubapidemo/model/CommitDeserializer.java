package com.example.githubapidemo.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;

public class CommitDeserializer extends StdDeserializer<Commit> {


    public CommitDeserializer() {
        this(null);
    }

    public CommitDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Commit deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Commit commit = new Commit();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode node = mapper.readTree(jsonParser);

        JsonNode commitNode = node.get("commit");

        JsonNode authorNode = commitNode.get("author");
        JsonNode authorEmail = authorNode.get("email");
        JsonNode commitDate = authorNode.get("date");

        JsonNode commitMessage = commitNode.get("message");
        JsonNode commitURL = commitNode.get("url");

        JsonNode authorUser = node.get("author");
        authorUser = authorUser.get("login");

        Date date = mapper.convertValue(commitDate.asText(), Date.class);
        commit.setCommitDate(date);

        commit.setCommitAuthorEmail(authorEmail.asText());
        commit.setCommitAuthorUser(authorUser.asText());
        commit.setCommitMessage(commitMessage.asText());
        commit.setCommitURL(commitURL.asText());

        return commit;
    }
}
