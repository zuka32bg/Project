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
public class Macka extends Ljubimac{

    int a;

    public Macka(String ime, int brNed, String rasa, String sifra) {
        super(ime, brNed, rasa, sifra);
    }
    
    public Macka(String ime, int brNed, String rasa) {
        super(ime, brNed, rasa);
    }
    
    @Override
    public String generisiIndentifikcaiju() {
        //{x, y, z, 1, 3, 5, 7, 9}.
        String chars = "xyz13579";
        String sifra = "";
        Random rand = new Random();//random generator
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(chars.length());
            sifra += chars.charAt(index);
        }
        return sifra;
    }
    
    public String toString(){
        return "[Macka] #"+getSifra()+" "+super.toString();
    }
    
      public static boolean verifikacijaSifre(String sifra){
        String chars = "xyz13579";
        for (int i = 0; i < sifra.length(); i++) {
            if(chars.indexOf(sifra.charAt(i)) == -1){//nema ga u chars
                return false;
            }
        }
        return true;
    }

    @Override
    public String toFile() {
        return "M, "+getIme()+", "+getRasa()+", "+getBrNed()+", "+getSifra();
    }
}
