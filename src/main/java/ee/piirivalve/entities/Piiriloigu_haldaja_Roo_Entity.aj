// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import ee.piirivalve.entities.Piiriloigu_haldaja;
import java.lang.Long;
import java.util.List;

privileged aspect Piiriloigu_haldaja_Roo_Entity {
    
    public static long Piiriloigu_haldaja.countPiiriloigu_haldajas() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Piiriloigu_haldaja o", Long.class).getSingleResult();
    }
    
    public static List<Piiriloigu_haldaja> Piiriloigu_haldaja.findAllPiiriloigu_haldajas() {
        return entityManager().createQuery("SELECT o FROM Piiriloigu_haldaja o", Piiriloigu_haldaja.class).getResultList();
    }
    
    public static Piiriloigu_haldaja Piiriloigu_haldaja.findPiiriloigu_haldaja(Long id) {
        if (id == null) return null;
        return entityManager().find(Piiriloigu_haldaja.class, id);
    }
    
    public static List<Piiriloigu_haldaja> Piiriloigu_haldaja.findPiiriloigu_haldajaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Piiriloigu_haldaja o", Piiriloigu_haldaja.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
