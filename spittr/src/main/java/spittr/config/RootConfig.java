package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public SpittleRepository createStubSpittleRepository() {
        final String[] spittleMsg = {
                "Spittles go fourth!",
                "Spittle spittle spittle",
                "Here another spittle",
                "Hello World! An Spittle!"
        };
        return (max, count) -> {
            List<Spittle> result = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                result.add(new Spittle(spittleMsg[i % spittleMsg.length], new Date()));
            }

            return result;
        };
    }
}
