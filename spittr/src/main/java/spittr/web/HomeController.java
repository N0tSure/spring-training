package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created on 23 Apr, 2017.
 *
 * @author Artemis A. Sirosh
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        messageSource.getMessage("spittr.header.homeLink", null, Locale.US);
        return "home";
    }

}
