package ee.piirivalve.web;

import ee.piirivalve.entities.Vaeosa_alluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vaeosa_alluvuses", formBackingObject = Vaeosa_alluvus.class)
@RequestMapping("/vaeosa_alluvuses")
@Controller
public class Vaeosa_alluvusController {
}
