package soundsystem;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:sound-system.xml")
@ActiveProfiles("hardDaysNight")
public class CDPlayerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CDPlayerTest.class);

    @Autowired
    private CompactDisk revolver;

    @Autowired
    private CompactDisk realDisk;

    @Autowired
    private CompactDisk whiteAlbum;

    @Value("#{2 * T(Math).PI * 0.5}")
    private Object value;

    @Test
    public void spellTest() throws Exception {
        LOGGER.info(value.getClass().getSimpleName() + " : " + value);
    }

    @Test
    public void cdShouldNotBeNull() {
        Assert.assertNotNull(whiteAlbum);
        whiteAlbum.play();
    }

}
