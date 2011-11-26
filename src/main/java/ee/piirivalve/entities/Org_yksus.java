package ee.piirivalve.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import org.springframework.format.annotation.DateTimeFormat;
import ee.piirivalve.entities.Vaeosa;
import ee.piirivalve.entities.Org_yksus;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Org_yksus {
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
	private Vaeosa vaeosa;

	@ManyToOne
	private Org_yksus org_yksus;

	@OneToMany(mappedBy = "org_yksus")
	private Set<Org_yksus> org_yksused;

	public Vaeosa getVaeosa() {
	    return vaeosa;
	}

	public void setVaeosa(Vaeosa param) {
	    this.vaeosa = param;
	}

	public Org_yksus getOrg_yksus() {
	    return org_yksus;
	}

	public void setOrg_yksus(Org_yksus param) {
	    this.org_yksus = param;
	}

	public Set<Org_yksus> getOrg_yksused() {
	    return org_yksused;
	}

	public void setOrg_yksused(Set<Org_yksus> param) {
	    this.org_yksused = param;
	}
}
