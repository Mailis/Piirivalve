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
}
