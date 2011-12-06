package ee.piirivalve.web;

import java.io.UnsupportedEncodingException; 
import java.util.ArrayList;
import java.util.Collection; 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.validation.Valid;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap; 
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils; 
import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import ee.piirivalve.entities.Voimalik_alluvus;


@RequestMapping("/adminyksuseliigiredaktor/**")
@Controller
public class AdminYksuseLiigiRedaktor {
/*	
    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }
*/    
    //kui pealehel ollaks esimest korda
    @RequestMapping
    public String index(@RequestParam(required = false) Long liigiID,Model uiModel) {
    	//kui siia formi tullakse esimest korda
       createForm(liigiID,uiModel);
        return "adminyksuseliigiredaktor/index";
    } 
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute("liigiID") Long liigiID, Model uiModel) {
    	                                    //"liigiID" saadab siia 
    	                                    //Voimalik_alluvusController
    	                                    //meetodist 'public String create(..)'
    	
    	
    	if(liigiID != null){//kui siia formi tullakse alluvaid loomast
    		//na:ita samu andmeid uuesti
    		
    		Riigi_admin_yksuse_liik alluvategaLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(liigiID);
     		Riigi_admin_yksuse_liik u = new Riigi_admin_yksuse_liik();
     		u = alluvategaLiik; //see ta:idab textboxid endiste andmetega
    		
    		uiModel.addAttribute("tagasiLiik", u);
    		uiModel.addAttribute("alluvategaLiik", alluvategaLiik);
    		
    		//seda ion vaja <c:out..>va:a:rtuseks, et kuvada olemasolevaid alluvusi
    		Riigi_admin_yksuse_liik valitudLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(liigiID);
    		uiModel.addAttribute("valitudLiik", valitudLiik);
    		uiModel.addAttribute("alluvadAdminYksysed", annaOlOlAlluvad(valitudLiik));
    	}
        uiModel.addAttribute("riigi_admin_yksuse_liik", new Riigi_admin_yksuse_liik());
        addDateTimeFormatPatterns(uiModel);
        return "adminyksuseliigiredaktor/index";
    }
    
 
    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("riigi_admin_yksuse_liik_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    public void setAvajaMuutja(Riigi_admin_yksuse_liik riigi_admin_yksuse_liik)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        riigi_admin_yksuse_liik.setAvaja(userName);
    	riigi_admin_yksuse_liik.setMuutja(userName);
    	
    }
    
    //seda kasutatakse Allub: va:lja dropboxi jaoks
    @ModelAttribute("riigi_admin_yksuse_liiks_piiks")
    public Collection<Riigi_admin_yksuse_liik> populateRiigi_admin_yksuse_liiks() {
        return Riigi_admin_yksuse_liik.findAllRiigi_admin_yksuse_liiks();
    }
    
    
    
/*    //eemalda-nupuasi
    @RequestMapping(method = RequestMethod.GET)
    public String updateForm(@PathVariable("ylemusLiik") Long ylemusLiikid, 
    		                 @PathVariable("alluvLiikLiik") Long alluvLiikid, Model uiModel, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        
        Riigi_admin_yksuse_liik YlemusLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(ylemusLiikid);
		
		Riigi_admin_yksuse_liik AlluvLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(alluvLiikid);
		
		Voimalik_alluvus v6i = null;
		for(Voimalik_alluvus va : Voimalik_alluvus.findAllVoimalik_alluvuses()){
    		if(va.getRiigi_admin_yksuse_liik()== YlemusLiik && va.getVoimalik_alluv_liik() == AlluvLiik){
    			v6i = va;
    		}
    	}
		uiModel.addAttribute("ylemuslikLiik", YlemusLiik);
    	uiModel.addAttribute("voimalik_alluvus", v6i);
        addDateTimeFormatPatterns(uiModel);
        YlemusLiik = updateMyAssEemalda(YlemusLiik, v6i, bindingResult, uiModel, httpServletRequest);
        return "redirect:/adminyksuseliigiredaktor/index" +"?liigiID=" + YlemusLiik.getId();
    }*/
    
    @RequestMapping(value="index?liigiID={ylemusLiik}", method = RequestMethod.PUT)
    public Riigi_admin_yksuse_liik updateMyAssEemalda(@PathVariable Long ylemusLiik, @RequestParam(required = false) Long alluvLiik, Model uiModel) {
Riigi_admin_yksuse_liik YlemusLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(ylemusLiik);
		
		Riigi_admin_yksuse_liik AlluvLiik = Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(alluvLiik);
		
		Voimalik_alluvus v6i = null;
		for(Voimalik_alluvus va : Voimalik_alluvus.findAllVoimalik_alluvuses()){
    		if(va.getRiigi_admin_yksuse_liik()== YlemusLiik && va.getVoimalik_alluv_liik() == AlluvLiik){
    			v6i = va;
    		}
    	}
		uiModel.addAttribute("ylemuslikLiik", YlemusLiik);
    	uiModel.addAttribute("voimalik_alluvus", v6i);
        addDateTimeFormatPatterns(uiModel);
        return YlemusLiik;
    }
    
    
    //admin.liigi olemasolevad alluvad
    //@ModelAttribute("JubaOlemasOlevadAlluvad")
    List<Riigi_admin_yksuse_liik > annaOlOlAlluvad(Riigi_admin_yksuse_liik valitudLiik ){
    	OlemasOlevadAlluvad ooaall = OlemasOlevadAlluvad.findAlluvadForAdminLiik(valitudLiik);
    	List<Riigi_admin_yksuse_liik> ololAlluvad = ooaall.getLiikItems();
    	return ololAlluvad;
    }
}
