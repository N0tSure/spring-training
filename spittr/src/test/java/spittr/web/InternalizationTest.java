package spittr.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spittr.config.RootConfig;
import spittr.config.WebConfig;

import java.io.IOException;
import java.util.Locale;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <p>
 * Created on 02.10.2017.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("file:web")
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class InternalizationTest extends AbstractSpittrIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public InternalizationTest() throws IOException {
        super("no_photo.png");
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void shouldReturnDefaultLocalePage() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Spittr!")));

    }

    @Test
    public void shouldReturnRussianLocalizedPage() throws Exception {

        mockMvc.perform(get("/?lang=ru"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Добро пожаловать в Spittr!")))
                .andExpect(result -> result.getResponse().getLocale().equals(Locale.forLanguageTag("ru")))
                .andReturn();

    }
}
