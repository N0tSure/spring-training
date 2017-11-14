package spittr.web;

import org.junit.Before;
import org.junit.Test;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import spittr.config.RootConfig;
import spittr.config.WebConfig;
import spittr.data.SpitterRepository;
import spittr.model.Spitter;
import spittr.service.ResourceService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

        SpitterRepository repository = webApplicationContext.getBean(SpitterRepository.class);
        ResourceService resourceService = webApplicationContext.getBean(ResourceService.class);

        Spitter savedSpitter = repository.findByUsername("sirosh");
        LOGGER.info("Saved spitter: {}", savedSpitter);

        String spitterProfilePicture = resourceService.findSpitterProfilePicture(savedSpitter);
        File profilePicture = new File(this.getProfilePicturesDirectory(), spitterProfilePicture);
        assertTrue("Profile picture file not exists", profilePicture.exists());
        assertNotEquals("Profile picture not found", this.getDefaultPictureFile(), profilePicture);

        LOGGER.info("Profile picture founded: {}", spitterProfilePicture);

        byte[] savedProfilePictureBytes = Files.readAllBytes(Paths.get(profilePicture.toURI()));
        assertTrue(
                "Loaded file's content not matching expectations",
                Arrays.equals(savedProfilePictureBytes, profilePictureFile.getBytes())
        );
    }


    @Test
    public void shouldAccessToUploadedImage() throws Exception {
        SpitterRepository repository = webApplicationContext.getBean(SpitterRepository.class);
        ResourceService resourceService = webApplicationContext.getBean(ResourceService.class);

        Spitter spitter = repository.save(new Spitter());
        MultipartFile spitterProfileMultipartFile = new MockMultipartFile("spitterProfile", "foobar".getBytes());

        resourceService.saveSpitterProfilePicture(spitter, spitterProfileMultipartFile);

        String spitterProfilePictureName = resourceService.findSpitterProfilePicture(spitter);

        mockMvc.perform(MockMvcRequestBuilders.get("/images/profile/" + spitterProfilePictureName))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().bytes("foobar".getBytes()));

    }
}
