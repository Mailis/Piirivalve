// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import java.lang.String;
import java.util.Date;

privileged aspect Piiriloigu_haldaja_Roo_JavaBean {
    
    public String Piiriloigu_haldaja.getKommentaar() {
        return this.kommentaar;
    }
    
    public void Piiriloigu_haldaja.setKommentaar(String kommentaar) {
        this.kommentaar = kommentaar;
    }
    
    public Date Piiriloigu_haldaja.getAlates() {
        return this.alates;
    }
    
    public void Piiriloigu_haldaja.setAlates(Date alates) {
        this.alates = alates;
    }
    
    public Date Piiriloigu_haldaja.getKuni() {
        return this.kuni;
    }
    
    public void Piiriloigu_haldaja.setKuni(Date kuni) {
        this.kuni = kuni;
    }
    
}
