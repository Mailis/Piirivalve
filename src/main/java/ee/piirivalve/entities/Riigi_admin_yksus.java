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
import ee.piirivalve.entities.Vaeosa;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;
import ee.piirivalve.entities.Admin_alluvus;
import ee.piirivalve.entities.Ruumiyksus;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Riigi_admin_yksus {
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
	private Riigi_admin_yksuse_liik riigi_admin_yksuse_liik;

	@OneToMany(mappedBy = "riigi_admin_yksus")
	private Set<Vaeosa> vaeosad;

	@OneToMany(mappedBy = "ylemus_yksus")
	private Set<Admin_alluvus> admin_alluvused_1;

	@OneToMany(mappedBy = "alluv_yksus")
	private Set<Admin_alluvus> admin_alluvused_2;

	@OneToMany(mappedBy = "riigi_admin_yksus")
	private Set<Ruumiyksus> ruumiyksused;

	public Riigi_admin_yksuse_liik getRiigi_admin_yksuse_liik() {
	    return riigi_admin_yksuse_liik;
	}

	public void setRiigi_admin_yksuse_liik(Riigi_admin_yksuse_liik param) {
	    this.riigi_admin_yksuse_liik = param;
	}

	public Set<Vaeosa> getVaeosad() {
	    return vaeosad;
	}

	public void setVaeosad(Set<Vaeosa> param) {
	    this.vaeosad = param;
	}

	public Set<Admin_alluvus> getAdmin_alluvused_1() {
	    return admin_alluvused_1;
	}

	public void setAdmin_alluvused_1(Set<Admin_alluvus> param) {
	    this.admin_alluvused_1 = param;
	}

	public Set<Admin_alluvus> getAdmin_alluvused_2() {
	    return admin_alluvused_2;
	}

	public void setAdmin_alluvused_2(Set<Admin_alluvus> param) {
	    this.admin_alluvused_2 = param;
	}

	public Set<Ruumiyksus> getRuumiyksused() {
	    return ruumiyksused;
	}

	public void setRuumiyksused(Set<Ruumiyksus> param) {
	    this.ruumiyksused = param;
	}
}
