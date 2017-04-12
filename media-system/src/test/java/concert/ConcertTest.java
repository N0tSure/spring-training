package concert;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.CompactDisk;
import soundsystem.Controllable;
import soundsystem.config.CDPlayerConfig;

/**
 * Created by cresh on 10.04.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class ConcertTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(ConcertTest.class);

    @Autowired
    private Performance woodStockFestival;

    @Autowired
    private Performance theaterDrama;

    @Autowired
    private CompactDisk revolver;

    @Autowired
    private Controllable hardDaysNight;

    @Autowired
    private TrackCounter counter;

    @Test
    public void woodStockTest() throws Exception {
        woodStockFestival.perform();
        revolver.play();
    }

    @Test
    public void showTest() throws Exception {
        theaterDrama.perform();

    }

    @Test
    public void trackCounter() throws Exception {
        hardDaysNight.playTrack(1);
        hardDaysNight.playTrack(1);
        hardDaysNight.playTrack(1);
        hardDaysNight.playTrack(2);
        hardDaysNight.playTrack(2);

        assertEquals(0, counter.getPlayCount(0));
        assertEquals(3, counter.getPlayCount(1));
        assertEquals(2, counter.getPlayCount(2));
    }

    @Test
    public void introduction() throws Exception {
        ((Encoreable) theaterDrama).performEncore();
        LOGGER.info("Test look like passed");
    }
}
