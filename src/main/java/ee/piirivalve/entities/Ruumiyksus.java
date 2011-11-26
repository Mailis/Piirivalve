package ee.piirivalve.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import ee.piirivalve.entities.Riigi_admin_yksus;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Ruumiyksus {
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
    private Date suletud;

    @NotNull
    @Size(max = 18)
    private String kood;

    @NotNull
    @Size(max = 18)
    private String nimetus;

    @NotNull
    @Size(max = 18)
    private String aadress;

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
	private Riigi_admin_yksus riigi_admin_yksus;

	public Riigi_admin_yksus getRiigi_admin_yksus() {
	    return riigi_admin_yksus;
	}

	public void setRiigi_admin_yksus(Riigi_admin_yksus param) {
	    this.riigi_admin_yksus = param;
	}
}
