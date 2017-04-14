package concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 11.04.2017.
 *
 * @author Artemis A. Sirosh
 */
public class TheaterDrama implements Performance {
    private static final Logger LOGGER = LoggerFactory.getLogger(TheaterDrama.class);

    @Override
    public void perform() {
        LOGGER.info("Theater Drama");
    }
}
