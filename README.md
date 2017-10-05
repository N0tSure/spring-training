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

## About web application internationalization

### Configure [MessageSource](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html)

To enable international support, first should be created `org.springframework.context.MessageSource` 
instance, at example:

```java
public class WebConfig {
    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
```
Below, in code fragment bean definition, which load **.properties** file, using `java.util.ResourceBundle`. 
It's possible set single or a few **.property** files as basename for `MessageSource`, `setBasename(basename:String)`
may will used for single file, and `setBasenames(basename:String[])` for several.

> Note:
> By default encoding of **.properties** files `ISO-8859-1`. Therefore, Russian, Chinese symbols may will decoded
> incorrectly. To avoid this use escaping for these symbols.

### Set up [LocaleResolver](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/LocaleResolver.html)

For changing locale in web application, should be available instance of `org.springframework.web.servlet.LocaleResolver` 
in application context. This bean provide resolving locale for **HTTP** request, and set locale for response.

```java
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }
    
    @Bean
    LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
```
There `org.springframework.web.servlet.i18n.SessionLocaleResolver` serves LocaleResolver, this implementation uses 
locale attribute in user's session. Also there set default locale for fallback.

For handling set locale value as parameter for **HTTP** request, should created instance of 
`org.springframework.web.servlet.i18n.LocaleChangeInterceptor` (which intercept parameter passed in request, 
parameter's name set in `setParamName(paramName:String)`, or used default) with locale switching. Interceptor must be
registered.

### Internationalization & Thymeleaf

When resolving views was chose Thymeleaf, MessageSource should set to [TemplateEngine](http://www.thymeleaf.org/apidocs/thymeleaf/3.0.0.BETA03/org/thymeleaf/TemplateEngine.html).

```java
public class WebConfig {
    private TemplateEngine templateEngine(ITemplateResolver resolver, MessageSource messageSource) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(resolver);
        engine.setMessageSource(messageSource);
        return engine;
    }
}
```

## Formatting dates

When attribute of particular type in [Model](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/ui/Model.html)
should be converted to string, or string should converted to particular type may be useful [Formatter](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/format/Formatter.html).
Formatter also must be registered in context.

```java
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateFormatter formatter = new DateFormatter("dd-MM-yyyy HH:mm");
        registry.addFormatterForFieldType(Date.class, formatter);
    }
}
```

## Downloading resources from CDN due pre-package

When to final artifact should be added some resources, .js, .css files may be useful [download-maven-plugin](https://github.com/maven-download-plugin/maven-download-plugin).
It's provide downloading some resource from url in particular directory at some **Maven** lifecycle phase. At example
given fragment say plugin download bootstrap.min.css in `WEB-INF/css` in target directory:

```xml
 <execution>
    <id>download-bootstrap-css</id>
    <phase>prepare-package</phase>
    <goals>
        <goal>wget</goal>
    </goals>
    <configuration>
        <url>http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css</url>
        <outputDirectory>${project.build.directory}/${project.build.finalName}/WEB-INF/css</outputDirectory>
    </configuration>
 </execution>
```
