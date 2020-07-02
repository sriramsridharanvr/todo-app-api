# A Sample API Application using the NG Framework

A template for building an API Application using the NG Framework that acts as an OAuth2 Resource server.

## Importing this project to your IDE

First, clone the repository if you haven't done it yet

    git clone https://github.com/yethitech/tenjin-screen-scanner.git

Then, import this project to your favorite IDE, along with the following projects:

    1. ngf-core
    2. ngf-ms-secure-audit

Now, you're good to go!

## Running this project

First, clone the repository if you haven't done it yet

    git clone https://github.com/yethitech/tenjin-screen-scanner.git

Next, build the dependent projects

    cd ngf-core
    mvn clean install

    cd ../ngf-ms-secure-audit
    mvn clean install

Now, you can run the identity service using the following command

    cd simple-ngf-api-app
    .\mvnw.cmd spring-boot:run

Alternatively, you may also package the project and run it as an executable JAR

    mvn clean package
    java -jar .\target\simple-ngf-api-app-0.0.1_SNAPSHOT.jar
