package ee.piirivalve.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

import ee.piirivalve.web.DateStuff;
import ee.piirivalve.web.SecurityStuff;

@MappedSuperclass
@RooJavaBean
@RooEntity(mappedSuperclass = true)
public abstract class BaseEntity {
	
	@PrePersist
	public void createAutoFill(){
		setAvaja(SecurityStuff.username());
		setMuutja(SecurityStuff.username());
		setAvatud(new Date());
		setMuudetud(new Date());
		setSuletud(DateStuff.END_OF_TIME);
	}
	
	
	@PreUpdate
	public void updateAutoFill(){
		setMuutja(SecurityStuff.username());
		setMuudetud(new Date());
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Size(max = 32)
    private String avaja;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date avatud;

    @Size(max = 32)
    private String muutja;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date muudetud;

    @Size(max = 32)
    private String sulgeja;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date suletud;
    
    public Date getMuudetud() {
		return muudetud;
	}


	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}

	public String getMuutja() {
		return muutja;
	}


	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}

	public String getAvaja() {
		return avaja;
	}


	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Date getAvatud() {
		return avatud;
	}


	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}

	public String getSulgeja() {
		return sulgeja;
	}


	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}

	public Date getSuletud() {
		return suletud;
	}


	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}
}
