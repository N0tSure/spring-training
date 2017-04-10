package concert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 10.04.2017.
 *
 * @author Artemis A. Sirosh
 */
public class WoodStockFestival implements Performance {
    private static final Logger LOGGER = LoggerFactory.getLogger(WoodStockFestival.class);

    @Override
    public void perform() {
        LOGGER.info("Woodstock concert");
    }
}
