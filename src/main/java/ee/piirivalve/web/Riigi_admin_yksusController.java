package ee.piirivalve.web;

import ee.piirivalve.entities.Riigi_admin_yksus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "riigi_admin_yksuses", formBackingObject = Riigi_admin_yksus.class)
@RequestMapping("/riigi_admin_yksuses")
@Controller
public class Riigi_admin_yksusController {
}
