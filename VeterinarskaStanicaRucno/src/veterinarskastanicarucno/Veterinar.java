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
public class Veterinar {
    private String ime;

    public Veterinar(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    
    public String toString(){
        return "Veterinar: Dr "+ime;
    }
    
    
}
