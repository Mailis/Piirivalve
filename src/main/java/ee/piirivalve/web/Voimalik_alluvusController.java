package ee.piirivalve.web;

import ee.piirivalve.entities.Voimalik_alluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "voimalik_alluvuses", formBackingObject = Voimalik_alluvus.class)
@RequestMapping("/voimalik_alluvuses")
@Controller
public class Voimalik_alluvusController {
}
