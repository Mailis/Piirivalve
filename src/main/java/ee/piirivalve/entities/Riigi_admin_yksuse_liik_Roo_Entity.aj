// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import ee.piirivalve.entities.Riigi_admin_yksuse_liik;
import java.lang.Long;
import java.util.List;

privileged aspect Riigi_admin_yksuse_liik_Roo_Entity {
    
    public static long Riigi_admin_yksuse_liik.countRiigi_admin_yksuse_liiks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Riigi_admin_yksuse_liik o", Long.class).getSingleResult();
    }
    
    public static List<Riigi_admin_yksuse_liik> Riigi_admin_yksuse_liik.findAllRiigi_admin_yksuse_liiks() {
        return entityManager().createQuery("SELECT o FROM Riigi_admin_yksuse_liik o", Riigi_admin_yksuse_liik.class).getResultList();
    }
    
    public static Riigi_admin_yksuse_liik Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liik(Long id) {
        if (id == null) return null;
        return entityManager().find(Riigi_admin_yksuse_liik.class, id);
    }
    
    public static List<Riigi_admin_yksuse_liik> Riigi_admin_yksuse_liik.findRiigi_admin_yksuse_liikEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Riigi_admin_yksuse_liik o", Riigi_admin_yksuse_liik.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
