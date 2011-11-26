package ee.piirivalve.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import ee.piirivalve.entities.Amet_vaeosas;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Vaeosa {
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
	private Riigi_admin_yksus riigi_admin_yksus;

	@OneToMany(mappedBy = "vaeosa")
	private Set<Org_yksus> org_yksused;

	@OneToMany(mappedBy = "vaeosa")
	private Set<Piiripunkti_alluvus> piiripunkti_alluvused;

	@OneToMany(mappedBy = "vaeosa")
	private Set<Piiriloigu_haldaja> piiriloigu_haldajad;

	@OneToMany(mappedBy = "vaeosa")
	private Set<Vahtkond> vahtkonnad;

	@OneToMany(mappedBy = "vaeosa")
	private Set<Amet_vaeosas> ametid_vaeosas;

	public Riigi_admin_yksus getRiigi_admin_yksus() {
	    return riigi_admin_yksus;
	}

	public void setRiigi_admin_yksus(Riigi_admin_yksus param) {
	    this.riigi_admin_yksus = param;
	}

	public Set<Org_yksus> getOrg_yksused() {
	    return org_yksused;
	}

	public void setOrg_yksused(Set<Org_yksus> param) {
	    this.org_yksused = param;
	}

	public Set<Piiripunkti_alluvus> getPiiripunkti_alluvused() {
	    return piiripunkti_alluvused;
	}

	public void setPiiripunkti_alluvused(Set<Piiripunkti_alluvus> param) {
	    this.piiripunkti_alluvused = param;
	}

	public Set<Piiriloigu_haldaja> getPiiriloigu_haldajad() {
	    return piiriloigu_haldajad;
	}

	public void setPiiriloigu_haldajad(Set<Piiriloigu_haldaja> param) {
	    this.piiriloigu_haldajad = param;
	}

	public Set<Vahtkond> getVahtkonnad() {
	    return vahtkonnad;
	}

	public void setVahtkonnad(Set<Vahtkond> param) {
	    this.vahtkonnad = param;
	}

	public Set<Amet_vaeosas> getAmetid_vaeosas() {
	    return ametid_vaeosas;
	}

	public void setAmetid_vaeosas(Set<Amet_vaeosas> param) {
	    this.ametid_vaeosas = param;
	}
}
