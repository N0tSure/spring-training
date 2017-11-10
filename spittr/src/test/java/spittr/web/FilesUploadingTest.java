package spittr.web;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import spittr.config.RootConfig;
import spittr.config.WebConfig;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * Created on 02.11.2017.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration("file:web")
@ContextConfiguration(classes = {RootConfig.class, WebConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class FilesUploadingTest extends AbstractSpittrIntegrationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilesUploadingTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public FilesUploadingTest() throws IOException {
        super("no_photo.png");
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void profilePictureUploadingTest() throws Exception {

        MockMultipartFile profilePictureFile = new MockMultipartFile(
                "profilePicture",
                "foo.jpg",
                MediaType.MULTIPART_FORM_DATA_VALUE,
                "foo".getBytes());

        mockMvc.perform(
                MockMvcRequestBuilders.fileUpload("/spitter/register")
                        .file(profilePictureFile)
                        .param("firstName", "Artemis")
                        .param("lastName", "Sirosh")
                        .param("email", "sirosh@iac.spb.ru")
                        .param("username", "sirosh")
                        .param("password", "asirosh")
        )
                .andDo(MockMvcResultHandlers.log());

    }
}
