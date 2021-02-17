/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinarskastanicarucno;

/**
 *
 * @author Lenovo
 */
public class Pregled {
    
    private Ljubimac pacijent;
    private Veterinar doktor;
    private Datum datum;
    private String opis;
    private Double cena;

    public Pregled(Ljubimac pacijent, Veterinar doktor, Datum datum, String opis, Double cena) {
        this.pacijent = pacijent;
        this.doktor = doktor;
        this.datum = datum;
        this.opis = opis;
        this.cena = cena;
    }

    public Ljubimac getPacijent() {
        return pacijent;
    }

    public void setPacijent(Ljubimac pacijent) {
        this.pacijent = pacijent;
    }

    public Veterinar getDoktor() {
        return doktor;
    }

    public void setDoktor(Veterinar doktor) {
        this.doktor = doktor;
    }

    public Datum getDatum() {
        return datum;
    }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Dr "+ doktor.getIme()+" pregleda "+ pacijent.getSifra()+" "+ pacijent.getIme();
    }
    public String ToFile() {
        return pacijent.toFile()+"; "+doktor.getIme()+"; "+datum+"; "+opis+"; "+cena;
    }
    
    
    
}
