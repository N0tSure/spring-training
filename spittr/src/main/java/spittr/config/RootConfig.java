package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.service.ResourceService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 22 Apr, 2017.
 *
 * @author Artemis A. Sirosh
 */

@Configuration
@ComponentScan(basePackages = "spittr", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ResourceService resourceService() throws IOException {
        String profilePictureDirectory = System.getenv("spittr.resources.pictures.profile");
        return ResourceService.createInstance(new URL(profilePictureDirectory), "no_photo.png");
    }
}
