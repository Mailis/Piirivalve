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
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
import org.springframework.format.annotation.DateTimeFormat;
import ee.piirivalve.entities.Riigi_admin_yksus;
import java.util.Set;
import javax.persistence.OneToMany;
import ee.piirivalve.entities.Voimalik_alluvus;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Riigi_admin_yksuse_liik {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
    @NotNull
    @Size(max = 32)
    private String avaja = minuNimi();// =  = sisseloginu()

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date avatud = new Date();;

	@NotNull
    @Size(max = 32)
    private String muutja = minuNimi();// = sisseloginu();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date muudetud = new Date();

    @Size(max = 32)
    private String sulgeja;// = sisseloginu();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud = maxDate();// = maxDate ();

    @NotNull
    @Size(max = 10)
    private String kood;

    @NotNull
    @Size(max = 100)
    private String nimetus;

    private String kommentaar;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date alates = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date kuni;

	@OneToMany(mappedBy = "riigi_admin_yksuse_liik")
	private Set<Riigi_admin_yksus> riigi_admin_yksused;

	@OneToMany(mappedBy = "riigi_admin_yksuse_liik")//ylemusüksuse liiginimetus
	private Set<Voimalik_alluvus> voimalikudAlluvused_1;

	@OneToMany(mappedBy = "voimalik_alluv_liik")//alluvüksuse liiginimetus
	private Set<Voimalik_alluvus> voimalikudAlluvused_2;

	public Set<Riigi_admin_yksus> getRiigi_admin_yksused() {
	    return riigi_admin_yksused;
	}

	public void setRiigi_admin_yksused(Set<Riigi_admin_yksus> param) {
	    this.riigi_admin_yksused = param;
	}
	//ylemusüksuse liiginimetus
	public Set<Voimalik_alluvus> getVoimalikudAlluvused_1() {
	    return voimalikudAlluvused_1;
	}
	//ylemusüksuse liiginimetus
	public void setVoimalikudAlluvused_1(Set<Voimalik_alluvus> param) {
	    this.voimalikudAlluvused_1 = param;
	}
	//alluvüksuse liiginimetus
	public Set<Voimalik_alluvus> getVoimalikudAlluvused_2() {
	    return voimalikudAlluvused_2;
	}
	//alluvüksuse liiginimetus
	public void setVoimalikudAlluvused_2(Set<Voimalik_alluvus> param) {
	    this.voimalikudAlluvused_2 = param;
	}

//Date 
    public void setAvatud(Date avatud) {
        this.avatud = new Date();
    }     
    public void setMuudetud(Date muudetud) {
        this.muudetud = new Date();
    }  
    public void setSuletud(Date suletud) {
        this.suletud = suletud;
    }
    /*    
    @PrePersist
    public void setAvaja(String avaja) {
        this.avaja = sisseloginu();
    }
    @PrePersist
    String sisseloginu(){
    	//final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
    	return userName;
    }
    
    public String sisseloginu(){
    	//final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String userName = auth.getName();
    	return userName;
    }
*/  
    final String minuNimi(){
    //	return (SecurityContextHolder.getContext().getAuthentication().getPrincipal()).toString();
	return "admin";
    }
    
    
	Date maxDate(){
    	
    	Calendar rightNow = Calendar.getInstance();
//      rightNow.set(9999, 12, 31);
//    	Date myDate = rightNow.getTime();///annb tulemuseks 31.01.10000
    	
    	rightNow.set(Calendar.YEAR, 9999);
    	rightNow.set(Calendar.MONTH, 11);
    	rightNow.set(Calendar.DAY_OF_MONTH, 31);
    
    	return rightNow.getTime();
    }    	
    	

    
}
