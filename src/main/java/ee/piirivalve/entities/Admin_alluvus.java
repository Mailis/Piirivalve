package ee.piirivalve.entities;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import ee.piirivalve.entities.Riigi_admin_yksus;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Admin_alluvus extends BaseEntity{
	
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
	private Riigi_admin_yksus ylemus_yksus;

	@ManyToOne
	private Riigi_admin_yksus alluv_yksus;

	public Riigi_admin_yksus getYlemus_yksus() {
	    return ylemus_yksus;
	}

	public void setYlemus_yksus(Riigi_admin_yksus param) {
	    this.ylemus_yksus = param;
	}

	public Riigi_admin_yksus getAlluv_yksus() {
	    return alluv_yksus;
	}

	public void setAlluv_yksus(Riigi_admin_yksus param) {
	    this.alluv_yksus = param;
	}
}
