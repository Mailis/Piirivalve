package ee.piirivalve.web;

import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.piirivalve.entities.Riigi_admin_yksus;
import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import ee.piirivalve.entities.Voimalik_alluvus;

@RequestMapping("/setup/**")
@Controller
public class SetupController {

	Calendar rightNow = Calendar.getInstance();
	Date myDate = (Date) rightNow.getTime();
    Date maxDate(){
    	
    	Calendar rightNow = Calendar.getInstance();
    	rightNow.set(Calendar.YEAR, 9999);
    	rightNow.set(Calendar.MONTH, 11);
    	rightNow.set(Calendar.DAY_OF_MONTH, 31);
    
    	return (Date) rightNow.getTime();
    } 
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
    			Riigi_admin_yksus.countRiigi_admin_yksuses() <= 0) {
    		Riigi_admin_yksuse_liik o = new Riigi_admin_yksuse_liik();
            
            //o.setAvaja(avaja)
            //o.setAvaja(avaja);
            //o.setMuutja(muutja);
            //o.setSulgeja(sulgeja);
            
    		o.setAlates(myDate);
            o.setMuudetud(myDate);
            o.setAvatud(myDate);
            o.setSuletud( maxDate());
            
            o.setNimetus("maakond");
            o.setKood("mk");
            o.persist();
            
            
            
            Riigi_admin_yksuse_liik o2 = new Riigi_admin_yksuse_liik();
            
            //o2.setAvaja(avaja)
            //o2.setAvaja(avaja);
            //o2.setMuutja(muutja);
            //o2.setSulgeja(sulgeja);
            
    		o2.setAlates(myDate);
            o2.setMuudetud(myDate);
            o2.setAvatud(myDate);
            o2.setSuletud( maxDate());
            
            o2.setNimetus("maakond");
            o2.setKood("mk");
            o2.persist();
            
            Voimalik_alluvus va = new Voimalik_alluvus();
            //va.setAvaja(avaja)
            //va.setAvaja(avaja);
            //va.setMuutja(muutja);
            //va.setSulgeja(sulgeja);
            
            
            va.setMuudetud(myDate);
            va.setAvatud(myDate);
            va.setSuletud( maxDate());
            
            va.setRiigi_admin_yksuse_liik(o);
            va.setVoimalik_alluv_liik(o2);
            va.persist();
            
            
            Riigi_admin_yksus ray = new Riigi_admin_yksus();
          //ray.setAvaja(avaja)
            //ray.setAvaja(avaja);
            //ray.setMuutja(muutja);
            //ray.setSulgeja(sulgeja);
            
            
            ray.setMuudetud(myDate);
            ray.setAvatud(myDate);
            ray.setSuletud( maxDate());
            
            ray.setKood("ray");
            ray.setNimetus("Harju maakond");
            ray.setRiigi_admin_yksuse_liik(o);
            ray.persist();  
            
            
            
            Riigi_admin_yksus ray2 = new Riigi_admin_yksus();
            //ray2.setAvaja(avaja)
              //ray2.setAvaja(avaja);
              //ray2.setMuutja(muutja);
              //ray2.setSulgeja(sulgeja);
              
              
              ray2.setMuudetud(myDate);
              ray2.setAvatud(myDate);
              ray2.setSuletud( maxDate());
              
              ray2.setKood("ray");
              ray2.setNimetus("Harju maakond");
              ray2.setRiigi_admin_yksuse_liik(o);
              
              ray2.persist(); 
            
        }
        return "setup/index";
    }
}
