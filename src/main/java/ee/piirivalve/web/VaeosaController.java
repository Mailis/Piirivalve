package ee.piirivalve.web;

import ee.piirivalve.entities.Vaeosa;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vaeosas", formBackingObject = Vaeosa.class)
@RequestMapping("/vaeosas")
@Controller
public class VaeosaController {
}
