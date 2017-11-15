package spittr.exceptions;

/**
 * <p>
 *     Created on 15.11.2017.
 *
 *     Thrown when uploaded image have unrecognized type.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
public class UnrecognizedPictureTypeException extends RuntimeException {

    public UnrecognizedPictureTypeException() {
    }

    public UnrecognizedPictureTypeException(String message) {
        super(message);
    }

    public UnrecognizedPictureTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrecognizedPictureTypeException(Throwable cause) {
        super(cause);
    }

}
