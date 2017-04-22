# Spring Training
There I'm study [Spring Framework](https://spring.io/docs)

## Maven project generation

[Maven in 5 minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

Project generation command:

`mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

| Parameter | Function |
|-----------|----------|
| `-DgroupId=com.mycompany.app`| Set group id |
| `-DartifactId=my-app` | Set artifact id |
| `-DarchetypeArtifactId=maven-archetype-quickstart` | Set archetype id |
| `-DinteractiveMode=false` | Disables interactive mode |

Generate full project in working directory, create **new folder**, which name equal 
value of `-DartifactId` parameter. In project generate `pom.xml` file and 
[standard project structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).

```
   my-app
     |-- pom.xml
     `-- src
         |-- main
         |   `-- java
         |       `-- com
         |           `-- mycompany
         |               `-- app
         |                   `-- App.java
         `-- test
             `-- java
                 `-- com
                     `-- mycompany
                         `-- app
                             `-- AppTest.java
                             
```

## About logging
Log4j introduction [there](http://artamonov.ru/2007/04/06/vvedenie-v-log4j)
