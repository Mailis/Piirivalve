package ee.piirivalve.web;

 
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.piirivalve.entities.Riigi_admin_yksuse_liik;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "riigi_admin_yksuse_liiks", formBackingObject = Riigi_admin_yksuse_liik.class)
@RequestMapping("/riigi_admin_yksuse_liiks")
@Controller
public class Riigi_admin_yksuse_liikController {
	
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Riigi_admin_yksuse_liik riigi_admin_yksuse_liik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {

    	if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riigi_admin_yksuse_liik", riigi_admin_yksuse_liik);
            addDateTimeFormatPatterns(uiModel);
            return "riigi_admin_yksuse_liiks/create";
        }     	
              
    	Collection<Riigi_admin_yksuse_liik> coll = Riigi_admin_yksuse_liik.findAllRiigi_admin_yksuse_liiks();
    	boolean notSuletud = true;
    	//kui siuke liik on baasis olemas ja ta pole suletud, 
    	//siis seda uuesti ei salvestata,
    	//vaid minnakse kohe alluvaid valima
    	for(Riigi_admin_yksuse_liik l : coll){ 
        	String l1 = l.getNimetus().toUpperCase();
        	String l2 = riigi_admin_yksuse_liik.getNimetus().toUpperCase();
        	//notSuletud = (riigi_admin_yksuse_liik.getSuletud()).after(new Date());
	    	if((l1.equals(l2)) && notSuletud ){ 
	    		
	    		return "redirect:/voimalik_alluvuses"+"?form&liigiID=" + l.getId();
	    	}
	    	
    	}        
     	
        uiModel.asMap().clear();
        riigi_admin_yksuse_liik.persist();
      //  //paneme samm kampunn nupule ka liigi id kĆ¼lge
       // uiModel.addAttribute("liigiID", encodeUrlPathSegment(riigi_admin_yksuse_liik.getId().toString(), httpServletRequest));
        return "redirect:/voimalik_alluvuses"+"?form&liigiID=" 
                   //seee on see rida, kuidas create paneb tavaliselt show-le id kaasa
                   + encodeUrlPathSegment(riigi_admin_yksuse_liik.getId().toString(), httpServletRequest); 
    }        		                           


}
