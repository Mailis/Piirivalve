// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import ee.piirivalve.entities.Amet_vaeosas;
import java.lang.Long;
import java.util.List;

privileged aspect Amet_vaeosas_Roo_Entity {
    
    public static long Amet_vaeosas.countAmet_vaeosases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Amet_vaeosas o", Long.class).getSingleResult();
    }
    
    public static List<Amet_vaeosas> Amet_vaeosas.findAllAmet_vaeosases() {
        return entityManager().createQuery("SELECT o FROM Amet_vaeosas o", Amet_vaeosas.class).getResultList();
    }
    
    public static Amet_vaeosas Amet_vaeosas.findAmet_vaeosas(Long id) {
        if (id == null) return null;
        return entityManager().find(Amet_vaeosas.class, id);
    }
    
    public static List<Amet_vaeosas> Amet_vaeosas.findAmet_vaeosasEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Amet_vaeosas o", Amet_vaeosas.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
