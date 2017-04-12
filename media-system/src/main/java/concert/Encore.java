package concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2017.
 *
 * @author Artemis A. Sirosh
 */
@Component
public class Encore implements Encoreable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Encore.class);
    @Override
    public void performEncore() {
        LOGGER.info("ENCORE PERFORMING");
    }
}
