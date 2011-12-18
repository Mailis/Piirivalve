package ee.piirivalve.web;

 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.PrePersist;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import ee.piirivalve.entities.Voimalik_alluvus;

import org.apache.commons.collections.MapUtils;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.collections.List;

@RooWebScaffold(path = "riigi_admin_yksuse_liiks", formBackingObject = Riigi_admin_yksuse_liik.class)
@RequestMapping("/riigi_admin_yksuse_liiks")
@Controller
public class Riigi_admin_yksuse_liikController {
	
	
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Riigi_admin_yksuse_liik liik, 
    		                    BindingResult bindingResult, Model uiModel, 
    		                    HttpServletRequest httpServletRequest) {
        
      	Collection<Riigi_admin_yksuse_liik> coll = Riigi_admin_yksuse_liik.findAllRiigi_admin_yksuse_liiks();
      	boolean liikOnBaasis = false;
      	String liigiId="";
    	String nupunimi = searchButtonName(httpServletRequest);
    	Riigi_admin_yksuse_liik lisatavAlluv = new Riigi_admin_yksuse_liik();
    	
    	if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riigi_admin_yksuse_liik", liik);
            addDateTimeFormatPatterns(uiModel);
            return "redirect:/adminyksuseliigiredaktor/index";
        }
    	
    	//kui siukse nimega liik on baasis olemas ja ta pole suletud, 
    	//siis seda uuesti ei salvestata,
    	//vaid minnakse kohe alluvaid valima
    	String nimetus = httpServletRequest.getParameterValues("nimetus")[0];
    	for(Riigi_admin_yksuse_liik l : coll){ 
    		if(l.getNimetus().equalsIgnoreCase(nimetus)){
    			if(l.getSuletud().after(new Date())){
    			    uiModel.asMap().clear();
    			    liikOnBaasis = true;
    			    liigiId = l.getId().toString();
    			    lisatavAlluv = l;
    			    lisatavAlluv.createAutoFill();
    			}
    		}
    	}	    	
    	
    	//see on uus liik, salvesta baasi
    	if(!liikOnBaasis){
            uiModel.asMap().clear();
            liik.persist();
            lisatavAlluv = liik;
            liigiId = liik.getId().toString();
    	}
     	//kui vajutati lisa-nuppu
    	if(nupunimi.equalsIgnoreCase("lisa")){      
             return "redirect:/voimalik_alluvuses"+"?form&liigiID=" + liigiId; 
    	}//kui vajutati salvesta-nuppu
    	else if(nupunimi.equalsIgnoreCase("salvesta") || nupunimi.equalsIgnoreCase("salvesta2")){
    		
    		//kysi riikuestilt valitud ylemusyksuse(dropdown boksist) id baasis
    		String[] bossiIDlist = httpServletRequest.getParameterValues("voimalikudAlluvused_1");
    		String bossiID = bossiIDlist[0];
    		Long bossiLong = Long.valueOf(bossiID);
    		//suhte ylemliik
    		Riigi_admin_yksuse_liik boss = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(bossiLong);

    	////uus alluvusuhe
    		Voimalik_alluvus v6imalik = new Voimalik_alluvus();
    		//määra ylemus
    		v6imalik.setRiigi_admin_yksuse_liik(boss);
    		//määra alluv
    		v6imalik.setVoimalik_alluv_liik(lisatavAlluv);
            //kommentaar
    		String komm = httpServletRequest.getParameterValues("kommentaar")[0];
    		v6imalik.setKommentaar(komm);
    		
    		//lisa baasi
    		//uiModel.asMap().clear();
    		v6imalik.persist();
    		
    		return "redirect:/adminyksuseliigiredaktor/index";
    	}
    	else
    		return "redirect:/voimalik_alluvuses";
    }        		                           
   
    //minu elupäästja, keda ma kolm nädalat otsisin:
    // http://stackoverflow.com/questions/2025280/have-multiple-submit-buttons-in-a-form-and-determine-which-was-pressed-in-a-cont
    String searchButtonName(final HttpServletRequest request) { 
        String buttonName = ""; 
        @SuppressWarnings("unchecked")
		Map<String, String[]> paramMap = request.getParameterMap(); 
        if (!paramMap.isEmpty()) { 
                for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                        /* Search for the button name as given in 
                           the 'value' attribute for the input tag */
                        if ("Lisa".equals(entry.getValue()[0]) || 
                        	"Eemalda".equals(entry.getValue()[0]) ||
                        	"Salvesta".equals(entry.getValue()[0]) ||
                        	"Salvesta2".equals(entry.getValue()[0])){ 
                                buttonName = entry.getKey(); 
                                break; 
                        } 
                } 
        } 
        return buttonName; 
    } 

}
