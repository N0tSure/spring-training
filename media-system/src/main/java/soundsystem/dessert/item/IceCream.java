package soundsystem.dessert.item;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import soundsystem.dessert.Dessert;
import soundsystem.dessert.annotations.Cold;
import soundsystem.dessert.annotations.Creamy;

/**
 * Created by cresh on 22.01.17.
 */
@Component
@Cold
@Creamy
public class IceCream implements Dessert {

}
