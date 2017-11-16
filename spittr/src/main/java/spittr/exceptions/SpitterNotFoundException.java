package spittr.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <p>
 *     Created on 15.11.2017.
 *
 *     Will thrown when not presented {@link spittr.model.Spitter} in
 *     {@link spittr.data.SpitterRepository} request attempt occurs.
 * </p>
 *
 * @author Artemis A. Sirosh
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spitter's profile not found")
public class SpitterNotFoundException extends RuntimeException {

    public SpitterNotFoundException() {
        super();
    }

    public SpitterNotFoundException(String message) {
        super(message);
    }

    public SpitterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpitterNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return String.format("Spitter not found: %s", this.getMessage());
    }
}
