package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import spittr.data.SpitterRepository;
import spittr.model.Spitter;
import spittr.service.ResourceService;

import javax.validation.Valid;
import java.io.IOException;

/**
 * Created on 28.04.2017.
 *
 * @author Artemis A. Sirosh
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private final SpitterRepository repository;
    private final ResourceService resourceService;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository, ResourceService resourceService) {
        this.repository = spitterRepository;
        this.resourceService = resourceService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processingRegistration(
            @RequestPart(name = "profilePicture", required = false) MultipartFile profilePicture,
            @Valid Spitter spitter,
            Errors errors
    ) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        Spitter savedSpitter = repository.save(spitter);
        resourceService.saveSpitterProfilePicture(savedSpitter, profilePicture);

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        Spitter spitter = repository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
