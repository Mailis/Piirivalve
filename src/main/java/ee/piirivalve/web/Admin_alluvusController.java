package ee.piirivalve.web;

import ee.piirivalve.entities.Admin_alluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "admin_alluvuses", formBackingObject = Admin_alluvus.class)
@RequestMapping("/admin_alluvuses")
@Controller
public class Admin_alluvusController {
}
