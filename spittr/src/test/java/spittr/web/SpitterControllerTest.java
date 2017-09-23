package spittr.web;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import spittr.config.RootConfig;
import spittr.data.SpitterRepository;
import spittr.model.Spitter;

import javax.validation.Validator;
import java.lang.reflect.Field;


/**
 * Created on 28.04.2017.
 *
 * @author Artemis A. Sirosh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SpitterControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpitterControllerTest.class);

    @Autowired
    private Validator validator;

    @Test
    public void fail_if_not_show_registration_form() throws Exception {
        SpitterController controller = new SpitterController(null);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"))
                .andExpect(
                        MockMvcResultMatchers.model().attribute("spitter", CoreMatchers.any(Spitter.class))
                );

    }

    @Test
    public void shouldProcessRegistration() throws Exception {

        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);

        Spitter unsaved = new Spitter(
                        "sirosh@iac.spb.ru",
                        "sirosh",
                        "asirosh",
                        "Artemis",
                        "Sirosh"
                );

        Spitter saved = new Spitter(
                "sirosh@iac.spb.ru",
                "sirosh",
                "asirosh",
                "Artemis",
                "Sirosh"
        );
        Field idField = Spitter.class.getDeclaredField("id");
        idField.setAccessible(true);
        idField.set(saved, 42L);

        LOGGER.info("Violated: {}", validator.validate(unsaved));
        LOGGER.info("Violated: {}", validator.validate(saved));

        LOGGER.info("Unsaved: id = {}, spitter = {}", unsaved.getId(), unsaved);
        LOGGER.info("Saved: id = {}, spitter = {}", saved.getId(), saved);

        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "Artemis")
                .param("lastName", "Sirosh")
                .param("email", "sirosh@iac.spb.ru")
                .param("username", "sirosh")
                .param("password", "asirosh")
        ).andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/sirosh"));

        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
    }
}
