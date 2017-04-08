package soundsystem.dessert.item;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import soundsystem.dessert.Dessert;
import soundsystem.dessert.annotations.Cold;
import soundsystem.dessert.annotations.Fruity;

/**
 * Created by cresh on 22.01.17.
 */
@Component
@Cold
@Fruity
public class Popsicle implements Dessert {
}
