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
public class FilesUploadingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilesUploadingTest.class);

    @ClassRule
    public static EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    private static File profilePictureLocation;

    private static File temporalProfilePictureLocation;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeClass
    public static void environmentSetUp() throws Exception {
        profilePictureLocation = temporaryFolder.newFolder();
        temporalProfilePictureLocation = temporaryFolder.newFolder();

        LOGGER.info("Picture location: {}", profilePictureLocation.getAbsolutePath());
        LOGGER.info("Picture temporal location: {}", temporalProfilePictureLocation.getAbsolutePath());

        environmentVariables.set(
                "spittr.resources.pictures.profile",
                profilePictureLocation.getAbsolutePath()
        );

        environmentVariables.set(
                "spittr.tmp.resources.pictures.profile",
                temporalProfilePictureLocation.getAbsolutePath()
        );
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
