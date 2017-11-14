package spittr.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import spittr.data.SpitterRepository;
import spittr.data.stub.SpitterRepositoryStub;
import spittr.model.Spitter;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * <p>
 * Created on 08.11.2017.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
public class ResourceServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceTest.class);

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private final SpitterRepository repository = new SpitterRepositoryStub();
    private final String defaultPictureName = "no_photo.png";
    private File profilePicturesDirectory;
    private ResourceService resourceService;

    @Before
    public void setUp() throws Exception {
        this.profilePicturesDirectory = temporaryFolder.newFolder();
        URL profilePicturesDirectoryURL =
                new URL(String.format("file:///%s", this.profilePicturesDirectory.getAbsolutePath()));

        LOGGER.info("Profile picture directory URL: {}", profilePicturesDirectoryURL);

        File defaultPicture = new File(this.profilePicturesDirectory, this.defaultPictureName);
        assertTrue("Unable create file", defaultPicture.createNewFile());
        LOGGER.info("Default profile picture: {}", defaultPicture);
        this.resourceService =
                ResourceService.createInstance(profilePicturesDirectoryURL, this.defaultPictureName);
    }

    @Test
    public void shouldReturnDefaultPhotoTest() throws Exception {

        String actualFileName = resourceService.findSpitterProfilePicture(repository.save(new Spitter()));

        assertEquals("Default file not found", this.defaultPictureName, actualFileName);

    }

    @Test
    public void shouldFindProfilePicture() throws Exception {
        final Spitter spitter = repository.save(new Spitter());

        final String profilePictureFileName = resourceService.estimateFileName(spitter);
        File profilePicture = new File(profilePicturesDirectory, profilePictureFileName);
        assertTrue("Unable create file", profilePicture.createNewFile());
        LOGGER.info("Profile picture file created: {}", profilePicture);

        String foundedProfilePictureName = resourceService.findSpitterProfilePicture(spitter);

        assertEquals("Picture not found", profilePictureFileName, foundedProfilePictureName);
    }

    @Test
    public void shouldSaveAndFindProfilePicture() throws Exception {
        final Spitter spitter = repository.save(new Spitter());
        MultipartFile profilePictureMultipartFile = new MockMultipartFile(
                "profilePicture",
                "foo.jpeg",
                MediaType.IMAGE_JPEG_VALUE,
                "foo".getBytes()
        );

        resourceService.saveSpitterProfilePicture(spitter, profilePictureMultipartFile);
        LOGGER.info("Saved picture file for profile: {}", spitter);

        File profilePictureFile =
                new File(this.profilePicturesDirectory, resourceService.estimateFileName(spitter) + ".jpeg");

        assertTrue("Picture file for profile not found", profilePictureFile.exists());
        LOGGER.info("Profile picture file founded: {}", profilePictureFile);

        assertTrue(
                "Content of picture file not matching to expectations",
                Arrays.equals(
                        profilePictureMultipartFile.getBytes(),
                        Files.readAllBytes(Paths.get(profilePictureFile.toURI()))
                )
        );

    }
}
