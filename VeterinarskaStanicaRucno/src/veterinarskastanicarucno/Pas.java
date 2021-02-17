/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinarskastanicarucno;

import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class Pas extends Ljubimac{
    
    private double masa;

    public Pas( String ime, int brNed, String rasa, String sifra, double masa) {
        super(ime, brNed, rasa, sifra);
        this.masa = masa;
    }

    public Pas( String ime, int brNed, String rasa, double masa) {
        super(ime, brNed, rasa);
        this.masa = masa;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }
    
     public String toString(){
        return "[Pas] #"+getSifra()+" "+super.toString();
    }

    @Override
    public String generisiIndentifikcaiju() {
          
        String chars = "abc02468";
        String sifra = "";
        Random rand = new Random();//random generator
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(chars.length());
            sifra += chars.charAt(index);
        }
        return sifra;
    }
    
    public static boolean verifikacijaSifre(String sifra){
        String chars = "abc02468";
        for (int i = 0; i < sifra.length(); i++) {
            if(chars.indexOf(sifra.charAt(i)) == -1){//nema ga u chars
                return false;
            }
        }
        return true;
    }

    @Override
     public String toFile() {
        return "P, "+getIme()+", "+getRasa()+", "+getBrNed()+", "+getMasa()+", "+getSifra();
    }
    
}
