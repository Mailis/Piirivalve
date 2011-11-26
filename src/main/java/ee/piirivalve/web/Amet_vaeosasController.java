package ee.piirivalve.web;

import ee.piirivalve.entities.Amet_vaeosas;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "amet_vaeosases", formBackingObject = Amet_vaeosas.class)
@RequestMapping("/amet_vaeosases")
@Controller
public class Amet_vaeosasController {
}
