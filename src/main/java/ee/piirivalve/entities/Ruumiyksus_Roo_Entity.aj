// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import ee.piirivalve.entities.Ruumiyksus;
import java.lang.Long;
import java.util.List;

privileged aspect Ruumiyksus_Roo_Entity {
    
    public static long Ruumiyksus.countRuumiyksuses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Ruumiyksus o", Long.class).getSingleResult();
    }
    
    public static List<Ruumiyksus> Ruumiyksus.findAllRuumiyksuses() {
        return entityManager().createQuery("SELECT o FROM Ruumiyksus o", Ruumiyksus.class).getResultList();
    }
    
    public static Ruumiyksus Ruumiyksus.findRuumiyksus(Long id) {
        if (id == null) return null;
        return entityManager().find(Ruumiyksus.class, id);
    }
    
    public static List<Ruumiyksus> Ruumiyksus.findRuumiyksusEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Ruumiyksus o", Ruumiyksus.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
