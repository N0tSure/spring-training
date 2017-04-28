package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.lang.reflect.Field;
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

        return new SpittleRepository() {

            @Override
            public Spittle findOne(long id) {
                return createSpittle(id);
            }

            @Override
            public List<Spittle> findSpittles(long max, int count) {
                List<Spittle> result = new ArrayList<>(count);
                long ids = max + 1;
                for (int i = 0; i < count; i++, ids++) {
                    result.add(createSpittle(ids));
                }
                return result;
            }

            private Spittle createSpittle(long id) {
                int rnd = (int) Math.round(Math.random() * spittleMsg.length);
                double latitude = Math.random() * 90;
                double longitude = Math.random() * 180;

                Spittle spittle = new Spittle(spittleMsg[rnd], new Date(), latitude, longitude);

                try {

                    Field idField = Spittle.class.getDeclaredField("id");
                    idField.setAccessible(true);
                    idField.setLong(spittle, id);
                } catch (NoSuchFieldException | IllegalAccessException exc) {
                   throw new RuntimeException(exc);
                }

                return spittle;
            }
        };
    }
}
