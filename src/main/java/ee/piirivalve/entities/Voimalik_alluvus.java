package ee.piirivalve.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Voimalik_alluvus {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
    @NotNull
    @Size(max = 32)
    private String avaja = minuNimi();// = logijaNimi()

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date avatud = new Date();

    @NotNull
    @Size(max = 32)
    private String muutja = minuNimi();// = logijaNimi()

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date muudetud = new Date();

    @Size(max = 32)
    private String sulgeja;// = logijaNimi()

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud = maxDate();// = maxDate ();

    private String kommentaar;

	@ManyToOne
	private Riigi_admin_yksuse_liik riigi_admin_yksuse_liik;

	@ManyToOne
	private Riigi_admin_yksuse_liik voimalik_alluv_liik;

	public Riigi_admin_yksuse_liik getRiigi_admin_yksuse_liik() {
	    return riigi_admin_yksuse_liik;
	}

	public void setRiigi_admin_yksuse_liik(Riigi_admin_yksuse_liik param) {
	    this.riigi_admin_yksuse_liik = param;
	}

	public Riigi_admin_yksuse_liik getVoimalik_alluv_liik() {
	    return voimalik_alluv_liik;
	}

	public void setVoimalik_alluv_liik(Riigi_admin_yksuse_liik param) {
	    this.voimalik_alluv_liik = param;
	}
	
	//Date 
    public void setAvatud(Date avatud) {
        this.avatud = new Date();
    }     
    public void setMuudetud(Date muudetud) {
        this.muudetud = new Date();
    }  
    public void setSuletud(Date suletud) {
        this.suletud = new Date();
    }
/*    //Logger
    public String logijaNimi(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        return userName;
    }
	  */  
    
    final String minuNimi(){
        //	return (SecurityContextHolder.getContext().getAuthentication().getPrincipal()).toString();
    	return "admin";
        }
    
   Date maxDate(){
    	
    	Calendar rightNow = Calendar.getInstance();
    	rightNow.set(Calendar.YEAR, 9999);
    	rightNow.set(Calendar.MONTH, 11);
    	rightNow.set(Calendar.DAY_OF_MONTH, 31);
    
    	return rightNow.getTime();
    } 
}
