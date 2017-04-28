package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.data.SpitterRepository;
import spittr.model.Spitter;

/**
 * Created on 28.04.2017.
 *
 * @author Artemis A. Sirosh
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private final SpitterRepository repository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.repository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processingRegistration(Spitter spitter) {
        repository.save(spitter);

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = repository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
