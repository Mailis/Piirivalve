package ee.piirivalve.web;

import ee.piirivalve.entities.Org_yksus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "org_yksuses", formBackingObject = Org_yksus.class)
@RequestMapping("/org_yksuses")
@Controller
public class Org_yksusController {
}
