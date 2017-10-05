package spittr.web;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 * Created on 23 Apr, 2017.
 *
 * @author Artemis A. Sirosh
 */

public class HomeControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeControllerTest.class);

    @Test
    public void failIf_returning_name_not_satisfy_view_name() throws Exception {
        HomeController controller = new HomeController();
        assertEquals("View name must satisfy home view", "home", controller.home());
        LOGGER.info("HomeController returns '{}' view name", controller.home());
    }

    @Test
    public void passIf_controller_returns_right_view() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        ;
    }
}
