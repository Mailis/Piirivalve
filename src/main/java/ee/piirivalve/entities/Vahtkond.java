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
import ee.piirivalve.entities.Vaeosa;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Vahtkond {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @NotNull
    @Size(max = 32)
    private String avaja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date avatud;

    @NotNull
    @Size(max = 32)
    private String muutja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date muudetud;

    @Size(max = 32)
    private String sulgeja;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud = maxDate();;

    @NotNull
    @Size(max = 20)
    private String kood;

    @NotNull
    @Size(max = 100)
    private String nimetus;

    private String kommentaar;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date alates;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date kuni;

	@ManyToOne
	private Vaeosa vaeosa;

	public Vaeosa getVaeosa() {
	    return vaeosa;
	}

	public void setVaeosa(Vaeosa param) {
	    this.vaeosa = param;
	}
	
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