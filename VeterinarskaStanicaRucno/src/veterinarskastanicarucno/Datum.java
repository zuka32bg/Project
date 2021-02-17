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
public class Datum {
    
    private int dan;
    private int mes;
    private int god;

    private int sat;
    private int min;

    public Datum(int dan, int mes, int god, int sat, int min) {
        this.dan = dan;
        this.mes = mes;
        this.god = god;
        this.sat = sat;
        this.min = min;
    }
    
  

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getGod() {
        return god;
    }

    public void setGod(int god) {
        this.god = god;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    
    
    @Override
    public String toString() {
        return dan+". "+mes+". "+god+"  "+sat+":"+min;
    }
    
    
    
}
