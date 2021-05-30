package com.example.githubapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Commit {

    @Id
    private String id;
    private String commitAuthorUser;
    private String commitAuthorEmail;
    private Date commitDate;
    private String commitMessage;
    private String commitURL;
}
