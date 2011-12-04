package ee.piirivalve.web;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.piirivalve.entities.Admin_alluvus;
import ee.piirivalve.entities.Riigi_admin_yksus;
import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import ee.piirivalve.entities.Voimalik_alluvus;

@RequestMapping("/setup/**")
@Controller
public class SetupController {

	@ModelAttribute("Setup")
    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
    	if(Riigi_admin_yksuse_liik.countRiigi_admin_yksuse_liiks() <= 0 ||
    			Voimalik_alluvus.countVoimalik_alluvuses() <= 0  ||
    			Riigi_admin_yksus.countRiigi_admin_yksuses() <= 0 ||
    			Admin_alluvus.countAdmin_alluvuses() <= 0) {

    		Riigi_admin_yksuse_liik o = new Riigi_admin_yksuse_liik();
            
            o.setAvaja(SecurityStuff.username());
            o.setAvaja(SecurityStuff.username());
            o.setMuutja(SecurityStuff.username());
            o.setSulgeja(SecurityStuff.username());
            
    		o.setAlates(new Date());
    		o.setKuni(DateStuff.END_OF_TIME);
            o.setMuudetud(new Date());
            o.setAvatud(new Date());
            o.setSuletud(DateStuff.END_OF_TIME);
            
            o.setNimetus("maakond");
            o.setKood("mk");
            o.persist();
            
            
            
            Riigi_admin_yksuse_liik o2 = new Riigi_admin_yksuse_liik();
            
            o2.setAvaja(SecurityStuff.username());
            o2.setAvaja(SecurityStuff.username());
            o2.setMuutja(SecurityStuff.username());
            o2.setSulgeja(SecurityStuff.username());
            
    		o2.setAlates(new Date());
    		o2.setKuni(DateStuff.END_OF_TIME);
            o2.setMuudetud(new Date());
            o2.setAvatud(new Date());
            o2.setSuletud(DateStuff.END_OF_TIME);

            o2.setNimetus("maakond");
            o2.setKood("mk");
            o2.persist();
            
            Voimalik_alluvus va = new Voimalik_alluvus();
            va.setAvaja(SecurityStuff.username());
            va.setAvaja(SecurityStuff.username());
            va.setMuutja(SecurityStuff.username());
            va.setSulgeja(SecurityStuff.username());
            
            
            va.setMuudetud(new Date());
            va.setAvatud(new Date());
            va.setSuletud(DateStuff.END_OF_TIME);
            
            va.setRiigi_admin_yksuse_liik(o);
            va.setVoimalik_alluv_liik(o2);
            va.persist();
            
            
            Riigi_admin_yksus ray = new Riigi_admin_yksus();
            ray.setAvaja(SecurityStuff.username());
            ray.setAvaja(SecurityStuff.username());
            ray.setMuutja(SecurityStuff.username());
            ray.setSulgeja(SecurityStuff.username());
            
            ray.setAlates(new Date());
            ray.setKuni(DateStuff.END_OF_TIME);
            ray.setMuudetud(new Date());
            ray.setAvatud(new Date());
            ray.setSuletud(DateStuff.END_OF_TIME);
            
            ray.setKood("ray");
            ray.setNimetus("Harju maakond");
            ray.setRiigi_admin_yksuse_liik(o);
            ray.persist();  
            
            
            
            Riigi_admin_yksus ray2 = new Riigi_admin_yksus();
        	  ray2.setAvaja(SecurityStuff.username());
              ray2.setAvaja(SecurityStuff.username());
              ray2.setMuutja(SecurityStuff.username());
              ray2.setSulgeja(SecurityStuff.username());
              
              ray2.setAlates(new Date());
              ray2.setKuni(DateStuff.END_OF_TIME);
              ray2.setMuudetud(new Date());
              ray2.setAvatud(new Date());
              ray2.setSuletud(DateStuff.END_OF_TIME);
              
              ray2.setKood("ray2");
              ray2.setNimetus("Kykakyla");
              ray2.setRiigi_admin_yksuse_liik(o2);
              
              ray2.persist(); 
            
              
              Admin_alluvus aa = new Admin_alluvus();
              aa.setAvaja(SecurityStuff.username());
              aa.setAvaja(SecurityStuff.username());
              aa.setMuutja(SecurityStuff.username());
              aa.setSulgeja(SecurityStuff.username());
              
              aa.setAlates(new Date());
              aa.setKuni(DateStuff.END_OF_TIME);
              aa.setMuudetud(new Date());
              aa.setAvatud(new Date());
              aa.setSuletud(DateStuff.END_OF_TIME);
              
              aa.setYlemus_yksus(ray);
              aa.setAlluv_yksus(ray2);
              
              aa.persist();
        }
        return "setup/index";
    }
}
