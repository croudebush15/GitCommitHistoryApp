# **GitCommitHistoryApp**

Simple web app that shows commit history for github projects

**PREREQUISITES**:

[Java 8](https://java.com/en/download/help/download_options.html)

[Maven 3.6.3](https://maven.apache.org/index.html)

[MongoDB (community edition)](https://docs.mongodb.com/manual/installation/)

[Angular](https://angular.io/guide/setup-local)

[Bootstrap v4.6.0](https://getbootstrap.com/)

**INSTRUCTIONS TO RUN PROJECT LOCALLY:**

clone repo into directory:

    git clone https://github.com/croudebush15/GitCommitHistoryApp.git

enter directory GitCommitHistoryApp/github-api-demo to run the backend server first.

    cd GitCommitHistoryApp/github-api-demo

from here run Spring Boot project GithubApiDemoApplication with this command (opens at port 8080):

    ./mvnw spring-boot:run

open a seperate command prompt in GitCommitHistoryApp/GithubCommitsHistoryApp/commits-history-app and install angular packages

    npm install

open angular server at port 4200:

    ng serve --open

Then press search button to see the commit history for this project! Also try other projects to see their own git commit histories. 
