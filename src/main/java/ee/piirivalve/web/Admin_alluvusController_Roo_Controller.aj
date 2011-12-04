// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.web;

import ee.piirivalve.entities.Admin_alluvus;
import ee.piirivalve.entities.Riigi_admin_yksus;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect Admin_alluvusController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String Admin_alluvusController.create(@Valid Admin_alluvus admin_alluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("admin_alluvus", admin_alluvus);
            addDateTimeFormatPatterns(uiModel);
            return "admin_alluvuses/create";
        }
        uiModel.asMap().clear();
        admin_alluvus.persist();
        return "redirect:/admin_alluvuses/" + encodeUrlPathSegment(admin_alluvus.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String Admin_alluvusController.createForm(Model uiModel) {
        uiModel.addAttribute("admin_alluvus", new Admin_alluvus());
        addDateTimeFormatPatterns(uiModel);
        return "admin_alluvuses/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String Admin_alluvusController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("admin_alluvus", Admin_alluvus.findAdmin_alluvus(id));
        uiModel.addAttribute("itemId", id);
        return "admin_alluvuses/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String Admin_alluvusController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("admin_alluvuses", Admin_alluvus.findAdmin_alluvusEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Admin_alluvus.countAdmin_alluvuses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("admin_alluvuses", Admin_alluvus.findAllAdmin_alluvuses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "admin_alluvuses/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String Admin_alluvusController.update(@Valid Admin_alluvus admin_alluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("admin_alluvus", admin_alluvus);
            addDateTimeFormatPatterns(uiModel);
            return "admin_alluvuses/update";
        }
        uiModel.asMap().clear();
        admin_alluvus.merge();
        return "redirect:/admin_alluvuses/" + encodeUrlPathSegment(admin_alluvus.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String Admin_alluvusController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("admin_alluvus", Admin_alluvus.findAdmin_alluvus(id));
        addDateTimeFormatPatterns(uiModel);
        return "admin_alluvuses/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String Admin_alluvusController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Admin_alluvus.findAdmin_alluvus(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/admin_alluvuses";
    }
    
    @ModelAttribute("admin_alluvuses")
    public Collection<Admin_alluvus> Admin_alluvusController.populateAdmin_alluvuses() {
        return Admin_alluvus.findAllAdmin_alluvuses();
    }
    
    @ModelAttribute("riigi_admin_yksuses")
    public Collection<Riigi_admin_yksus> Admin_alluvusController.populateRiigi_admin_yksuses() {
        return Riigi_admin_yksus.findAllRiigi_admin_yksuses();
    }
    
    void Admin_alluvusController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("admin_alluvus_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("admin_alluvus_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("admin_alluvus_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("admin_alluvus_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("admin_alluvus_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String Admin_alluvusController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
    
}