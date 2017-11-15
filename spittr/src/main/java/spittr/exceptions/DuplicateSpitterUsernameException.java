package spittr.exceptions;

/**
 * <p>
 *     Created on 15.11.2017.
 *
 *     Thrown when <strong>spitter</strong>, which username same as another
 *     spitter saved into {@link spittr.data.SpitterRepository}.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
public class DuplicateSpitterUsernameException extends RuntimeException {

    public DuplicateSpitterUsernameException() {
        super();
    }

    public DuplicateSpitterUsernameException(String message) {
        super(message);
    }

    public DuplicateSpitterUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateSpitterUsernameException(Throwable cause) {
        super(cause);
    }

}
