package soundsystem.config;

import concert.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import soundsystem.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@ImportResource("classpath:sound-system.xml")
@ComponentScan(basePackages = {"concert"})
@PropertySource("classpath:cd-config.properties")
public class CDPlayerConfig {

    private final Environment environment;

    @Autowired
    public CDPlayerConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Profile("random")
    public CompactDisk randomDisk() {
        if (Math.random() > 0.5) return new SgtPepper();
        else return new SgtPepper();
    }

    @Bean
    public Controllable hardDaysNight() {
        return new HardDaysNight(
                "Hard Days Night",
                "The Beatles",
                Arrays.asList(
                        "A Hard Day's Night",
                        "I Should Have Known Better",
                        "If I Fell"
                ));
    }

    @Bean
    @Conditional(RevolverCondition.class)
    public CompactDisk revolver() {
        BlankDisc revolver = new BlankDisc();
        revolver.setArtist(environment.getProperty("revolver.artist"));
        revolver.setTitle(environment.getProperty("revolver.title"));
        List<String> tracks = Arrays.asList(
                "Taxman",
                "Eleanor Rigby",
                "I'm Only Sleeping",
                "Love You To",
                "Here, There and Everywhere"
        );
        revolver.setTracks(tracks);
        return revolver;
    }

    @Bean
    public CompactDisk whiteAlbum(BlankDisc blankDisc) {
        blankDisc.setTitle(environment.getProperty("white.title"));
        blankDisc.setTracks(Arrays.asList(
                "Back In the U.S.S.R.",
                "Dear Prudence",
                "Glass Onion",
                "Ob-La-Di, Ob-La-Da",
                "Wild Honey Pie"
        ));
        return blankDisc;
    }

}