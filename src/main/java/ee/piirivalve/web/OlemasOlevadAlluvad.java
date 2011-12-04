package ee.piirivalve.web; 

import java.util.List; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query; 
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean; 
import ee.piirivalve.entities.Riigi_admin_yksuse_liik;


@Configurable
@RooJavaBean
public class OlemasOlevadAlluvad {
	@PersistenceContext
	EntityManager entityManager;
	
	public OlemasOlevadAlluvad() {
		
	}
	public OlemasOlevadAlluvad(Riigi_admin_yksuse_liik liik, List<Riigi_admin_yksuse_liik> liikItems) {
		this.adminLiik = liik;
		this.liikItems = liikItems;
	}
	
	Riigi_admin_yksuse_liik adminLiik;
	List<Riigi_admin_yksuse_liik> liikItems;
	
    @SuppressWarnings("unchecked")
	public static OlemasOlevadAlluvad findAlluvadForAdminLiik(Riigi_admin_yksuse_liik ral) {
    	Query q = entityManager().createQuery(
    	    "SELECT voimalik_alluv_liik " +
    	    "  FROM Voimalik_alluvus " + 
    	    "WHERE riigi_admin_yksuse_liik = :ylemus");
        q.setParameter("ylemus", ral);
        return new OlemasOlevadAlluvad(ral, q.getResultList());
    }
    
    public static final EntityManager entityManager() {
        EntityManager em = new OlemasOlevadAlluvad().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected");
        return em;
    }
}
