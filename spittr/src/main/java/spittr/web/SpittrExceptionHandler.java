package spittr.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spittr.exceptions.SpitterNotFoundException;

/**
 * <p>
 *     Created on 16.11.2017.
 * </p>
 * <p>
 *     Handles exception, which might thrown application wide
 * </p>
 *
 * @author Artemis A. Sirosh
 */
@ControllerAdvice
public class SpittrExceptionHandler {

    @ExceptionHandler(SpitterNotFoundException.class)
    public String spitterNotFoundExceptionHandler(SpitterNotFoundException exc, Model model) {
        model.addAttribute("exception", exc);
        return "error";
    }
}
