package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.CompactDisk;
import soundsystem.config.CDPlayerConfig;

/**
 * Created by cresh on 10.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class ConcertTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConcertTest.class);

    @Autowired
    private Performance performance;

    @Autowired
    private CompactDisk revolver;

    @Test
    public void woodStockTest() throws Exception {
        performance.perform();
        revolver.play();

    }
}
