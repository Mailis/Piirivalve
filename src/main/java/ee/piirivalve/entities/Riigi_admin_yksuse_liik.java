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
    @Size(max = 10)
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

	@OneToMany(mappedBy = "riigi_admin_yksuse_liik")
	private Set<Riigi_admin_yksus> riigi_admin_yksused;

	@OneToMany(mappedBy = "riigi_admin_yksuse_liik")
	private Set<Voimalik_alluvus> voimalikudAlluvused_1;

	@OneToMany(mappedBy = "voimalik_alluv_liik")
	private Set<Voimalik_alluvus> voimalikudAlluvused_2;

	public Set<Riigi_admin_yksus> getRiigi_admin_yksused() {
	    return riigi_admin_yksused;
	}

	public void setRiigi_admin_yksused(Set<Riigi_admin_yksus> param) {
	    this.riigi_admin_yksused = param;
	}

	public Set<Voimalik_alluvus> getVoimalikudAlluvused_1() {
	    return voimalikudAlluvused_1;
	}

	public void setVoimalikudAlluvused_1(Set<Voimalik_alluvus> param) {
	    this.voimalikudAlluvused_1 = param;
	}

	public Set<Voimalik_alluvus> getVoimalikudAlluvused_2() {
	    return voimalikudAlluvused_2;
	}

	public void setVoimalikudAlluvused_2(Set<Voimalik_alluvus> param) {
	    this.voimalikudAlluvused_2 = param;
	}
}
