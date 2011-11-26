package ee.piirivalve.web;

import ee.piirivalve.entities.Piiriloigu_haldaja;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piiriloigu_haldajas", formBackingObject = Piiriloigu_haldaja.class)
@RequestMapping("/piiriloigu_haldajas")
@Controller
public class Piiriloigu_haldajaController {
}
