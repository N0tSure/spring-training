package spittr.web;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created on 10.11.2017.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
public abstract class AbstractSpittrIntegrationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSpittrIntegrationTest.class);

    @ClassRule
    public static TemporaryFolder temporaryFolder = new TemporaryFolder();

    @ClassRule
    public static EnvironmentVariables environmentVariables = new EnvironmentVariables();

    private final File profilePicturesDirectory;
    private final File temporalProfilePicturesDirectory;
    private final File defaultPictureFile;

    protected AbstractSpittrIntegrationTest(final String defaultProfilePictureFileName) throws IOException {

        this.profilePicturesDirectory = temporaryFolder.newFolder();
        this.defaultPictureFile = new File(this.profilePicturesDirectory, defaultProfilePictureFileName);
        assertTrue("Default picture file was not created", this.defaultPictureFile.createNewFile());
        LOGGER.info("Profile picture directory: {}", this.profilePicturesDirectory);
        LOGGER.info("Default profile picture: {}", this.defaultPictureFile);

        this.temporalProfilePicturesDirectory = temporaryFolder.newFolder();
        LOGGER.info("Temporal profile picture directory: {}", this.temporalProfilePicturesDirectory);

        environmentVariables.set(
                "spittr.resources.pictures.profile", urlFromFile(this.profilePicturesDirectory)
        );

        environmentVariables.set(
                "spittr.tmp.resources.pictures.profile", urlFromFile(this.temporalProfilePicturesDirectory)
        );
    }

    public File getProfilePicturesDirectory() {
        return profilePicturesDirectory;
    }

    public File getTemporalProfilePicturesDirectory() {
        return temporalProfilePicturesDirectory;
    }

    public File getDefaultPictureFile() {
        return defaultPictureFile;
    }

    private String urlFromFile(File file) throws MalformedURLException {
        return file.toURI().toURL().toString();
    }
}
