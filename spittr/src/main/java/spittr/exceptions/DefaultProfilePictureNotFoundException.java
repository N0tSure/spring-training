package spittr.exceptions;

import java.io.FileNotFoundException;

/**
 * <p>
 *  Created on 15.11.2017.
 *
 *  Will be thrown if default profile picture was not found.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
public class DefaultProfilePictureNotFoundException extends FileNotFoundException {

    public DefaultProfilePictureNotFoundException() {
        super();
    }

    public DefaultProfilePictureNotFoundException(String message) {
        super(message);
    }


}
