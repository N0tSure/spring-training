package spittr.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import spittr.model.Spitter;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * <p>
 *     Field profilePictureDirectory must point on local filesystem directory, there
 *     will saved profile pictures files, and after found. Names of loaded file estimated as
 *     <strong>MD5 checksum</strong> from string, which created from {@link Spitter}'s id.
 *
 *     Field defaultPictureFileName provides name of profile's default picture
 *
 * Created on 08.11.2017.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
public class ResourceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceService.class);

    private File profilePictureDirectory;
    private String defaultPictureFileName;

    /**
     * Creates instance of {@link ResourceService}
     *
     * @param profilePictureDirectoryURL local filesystem directory
     * @param defaultPictureFileName name of default picture
     * @return ResourceService instance
     * @throws NullPointerException if profilePictureDirectoryURL or defaultPictureFileName is null
     * @throws IllegalStateException if profile picture directory or default picture not exists
     */
    public static ResourceService createInstance(
            final URL profilePictureDirectoryURL, final String defaultPictureFileName) {
        File profilePictureDirectory = new File(profilePictureDirectoryURL.getFile());

        checkNotNull(profilePictureDirectoryURL, "Profile directory URL is null");
        checkNotNull(defaultPictureFileName, "Default picture name is null");

        checkArgument(
                profilePictureDirectory.exists(),
                "Profile picture not exists: %s",
                profilePictureDirectory
        );

        checkArgument(
                new File(profilePictureDirectory, defaultPictureFileName).exists(),
                "Default profile picture: [%s] not found",
                defaultPictureFileName
        );

        return new ResourceService(profilePictureDirectory, defaultPictureFileName);
    }

    private ResourceService(File profilePictureDirectory, String defaultPictureFileName) {
        this.profilePictureDirectory = profilePictureDirectory;
        this.defaultPictureFileName = defaultPictureFileName;

    }

    /**
     * Find name of profile picture, from {@link Spitter}
     * @param spitter is profile, which picture will search
     * @return profile picture file name
     * @throws NullPointerException if spitter is null or spitter's id is null
     */
    public String findSpitterProfilePicture(final Spitter spitter) {

        final String expectedFileName =
                estimateFileName(checkNotNull(spitter, "Spitter is null"));

        LOGGER.debug("Looking up for: {} in {}", expectedFileName, profilePictureDirectory);

        String[] fileNames =
                profilePictureDirectory.list((dir, name) -> name.equals(expectedFileName));

        LOGGER.debug("Found: {}", Arrays.toString(fileNames));

        if (fileNames != null && Integer.compare(fileNames.length, 0) != 0) {
            return fileNames[0];
        } else {
            return defaultPictureFileName;
        }
    }

    /**
     * Saves picture from {@link MultipartFile} to file
     * @param spitter which profile picture will saved
     * @param profilePictureMultipartFile received file
     * @throws IOException if I/O errors occurs due saving
     * @throws NullPointerException if spitter is null or spitter's id is null
     */
    public void saveSpitterProfilePicture(
            final Spitter spitter, final MultipartFile profilePictureMultipartFile) throws IOException {

        if (profilePictureMultipartFile != null && !profilePictureMultipartFile.isEmpty()) {
            final String fileName = estimateFileName(checkNotNull(spitter, "Spitter is null"));
            File profilePictureFile = new File(this.profilePictureDirectory, fileName);
            profilePictureMultipartFile.transferTo(profilePictureFile);
        }

    }

    String estimateFileName(final Spitter spitter) {

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String spitterId = String.valueOf(checkNotNull(spitter.getId(), "Spitter's id is null"));
            // TODO: 09.11.2017 Add java.nio.Charset into build argument
            byte[] encodedInput = spitterId.getBytes();
            messageDigest.update(encodedInput);
            return DatatypeConverter.printHexBinary(messageDigest.digest());
        } catch (NoSuchAlgorithmException exc) {
            throw new RuntimeException(exc);
        }

    }
}
