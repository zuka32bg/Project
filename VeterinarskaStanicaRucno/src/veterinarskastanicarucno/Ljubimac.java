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
public abstract class Ljubimac {
    
    private String ime;
    private int brNed;
    private String rasa;
    private String sifra;

    public Ljubimac(String ime, int brNed, String rasa, String sifra) {
        this.ime = ime;
        this.brNed = brNed;
        this.rasa = rasa;
        this.sifra = sifra;
    }

      public Ljubimac(String ime, int brNed, String rasa) {
        this.ime = ime;
        this.brNed = brNed;
        this.rasa = rasa;
        this.sifra = generisiIndentifikcaiju();
    }

    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getBrNed() {
        return brNed;
    }

    public void setBrNed(int brNed) {
        this.brNed = brNed;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }
    
    public String toString(){
        return "Ime: "+ime+" starost: "+brNed+" nedelja, rasa: "+rasa;
    }
    
    //mora biti implementi rana u svim podklasama
    public abstract String generisiIndentifikcaiju();

    public abstract String toFile();
    
}
