package soundsystem.dessert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import soundsystem.dessert.annotations.Cold;
import soundsystem.dessert.annotations.Creamy;

/**
 * Created by cresh on 22.01.17.
 */

@Configuration
@ComponentScan(basePackages = "soundsystem.dessert.*")
public class DessertConfig {
    private Dessert dessert;

    @Autowired
    @Cold
    @Creamy
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
