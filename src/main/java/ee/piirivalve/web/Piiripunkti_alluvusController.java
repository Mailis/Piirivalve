package ee.piirivalve.web;

import ee.piirivalve.entities.Piiripunkti_alluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piiripunkti_alluvuses", formBackingObject = Piiripunkti_alluvus.class)
@RequestMapping("/piiripunkti_alluvuses")
@Controller
public class Piiripunkti_alluvusController {
}
