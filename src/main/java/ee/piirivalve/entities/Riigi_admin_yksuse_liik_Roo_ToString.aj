// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import java.lang.String;

privileged aspect Riigi_admin_yksuse_liik_Roo_ToString {
    
    public String Riigi_admin_yksuse_liik.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alates: ").append(getAlates()).append(", ");
        sb.append("Avaja: ").append(getAvaja()).append(", ");
        sb.append("Avatud: ").append(getAvatud()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Kommentaar: ").append(getKommentaar()).append(", ");
        sb.append("Kood: ").append(getKood()).append(", ");
        sb.append("Kuni: ").append(getKuni()).append(", ");
        sb.append("Muudetud: ").append(getMuudetud()).append(", ");
        sb.append("Muutja: ").append(getMuutja()).append(", ");
        sb.append("Nimetus: ").append(getNimetus()).append(", ");
        sb.append("Riigi_admin_yksused: ").append(getRiigi_admin_yksused() == null ? "null" : getRiigi_admin_yksused().size()).append(", ");
        sb.append("Suletud: ").append(getSuletud()).append(", ");
        sb.append("Sulgeja: ").append(getSulgeja()).append(", ");
        sb.append("VoimalikudAlluvused_1: ").append(getVoimalikudAlluvused_1() == null ? "null" : getVoimalikudAlluvused_1().size()).append(", ");
        sb.append("VoimalikudAlluvused_2: ").append(getVoimalikudAlluvused_2() == null ? "null" : getVoimalikudAlluvused_2().size());
        return sb.toString();
    }
    
}
