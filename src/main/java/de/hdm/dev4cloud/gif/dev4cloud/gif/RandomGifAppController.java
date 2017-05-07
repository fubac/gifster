package de.hdm.dev4cloud.gif.dev4cloud.gif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author patrick.kleindienst
 */

@Controller
@RequestMapping("/")
public class RandomGifAppController {

    private GifGenerator gifGenerator;

    @Autowired
    public RandomGifAppController(GifGenerator gifGenerator) {
        this.gifGenerator = gifGenerator;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String randomGifURL(Model model) {
        model.addAttribute("gifURL", gifGenerator.getRandomURL());
        return "index";
    }
}
