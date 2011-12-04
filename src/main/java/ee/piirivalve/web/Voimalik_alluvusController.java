package ee.piirivalve.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import ee.piirivalve.entities.Voimalik_alluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "voimalik_alluvuses", formBackingObject = Voimalik_alluvus.class)
@RequestMapping("/voimalik_alluvuses")
@Controller
public class Voimalik_alluvusController {
	
	
	//see controller peab loomiseks saama ylemusyksuse liigi id,
	//et see liik oleks ylemusena automaatselt ma:a:ratud
    @RequestMapping(params = "form", method = RequestMethod.GET)
                            //liigiID saadab siia klass 
                            //Riigi_admin_yksuse_liikController create-meetodist
    public String createForm(@RequestParam(required = false) Long liigiID, Model uiModel) {
    	Voimalik_alluvus va = new Voimalik_alluvus();
    	if(liigiID != null){
    		
    		va.setRiigi_admin_yksuse_liik(Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(liigiID));
    		//seda ion vaja <c:out..>va:a:rtuseks, et kuvada olemasolevaid alluvusi
    		Riigi_admin_yksuse_liik valitudLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(liigiID);
    		uiModel.addAttribute("valitudLiik", valitudLiik);
    		uiModel.addAttribute("alluvadAdminYksysed", annaOlOlAlluvad(valitudLiik));
    	}
    	uiModel.addAttribute("voimalik_alluvus", va);
        addDateTimeFormatPatterns(uiModel);
        return "voimalik_alluvuses/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Voimalik_alluvus voimalik_alluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("voimalik_alluvus", voimalik_alluvus);
            addDateTimeFormatPatterns(uiModel);
            return "voimalik_alluvuses/create";
        }
        uiModel.asMap().clear();
        voimalik_alluvus.persist();
        //seda attributi kasutada saab 
        //klassi AdminYksuseLiigiRedaktor meetodi createForm parameetrina!!!
        uiModel.addAttribute("liigiID", encodeUrlPathSegment(voimalik_alluvus.getRiigi_admin_yksuse_liik().getId().toString(), httpServletRequest));                                       //liigiID ilmub aadressireale 
        return "redirect:/adminyksuseliigiredaktor/index";//?liigiID=" + encodeUrlPathSegment(voimalik_alluvus.getRiigi_admin_yksuse_liik().getId().toString(), httpServletRequest);
        	
    }
    
    
    //admin.liigi olemasolevad alluvad
    //@ModelAttribute("JubaOlemasOlevadAlluvad")
    List<Riigi_admin_yksuse_liik > annaOlOlAlluvad(Riigi_admin_yksuse_liik valitudLiik ){
    	OlemasOlevadAlluvad ooaall = OlemasOlevadAlluvad.findAlluvadForAdminLiik(valitudLiik);
    	List<Riigi_admin_yksuse_liik> ololAlluvad = ooaall.getLiikItems();
    	return ololAlluvad;
    }
    
    
    
    
    
    
}
    
    
   
   

