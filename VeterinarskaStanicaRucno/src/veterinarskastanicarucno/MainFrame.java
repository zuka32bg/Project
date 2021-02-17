/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinarskastanicarucno;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class MainFrame extends HBox {

    private RadioButton radioPas;
    private RadioButton radioMacka;
    private ToggleGroup tgZivotinje;
    private HBox hbTop;

    private Label imeLab;
    private Label starostLab;
    private Label rasaLab;
    private Label masaLab;
    private VBox vbLabels;

    private TextField imeTf;
    private TextField starostTf;
    private TextField rasaTf;
    private TextField masaTf;
    private VBox vbTextFields;
    private HBox hbData;

    private Button dodajLjubimcaBtn;

    private ToggleGroup tgDoktori;
    private RadioButton radioDocLevo;
    private Button krajBtn;
    private RadioButton radioDocDesno;
    private HBox hbDoktori;

    private Button sledeciBtn;

    private VBox gornjiVB;
    private Pane gornjiPane;

    private Button ucitajJuceBtn;
    private Button upisiZaSutraBtn;
    private VBox vbLevo;

    private TextArea taDesno;
    private ComboBox cbDoktori;
    private Button preglediDoktoraBtn;
    private Button cekaonicaBtn;
    private HBox hbDesnoDole;
    private VBox vbDesno;

    //operativni atributi
    private ArrayList<Ljubimac> ljubimci;
    private ArrayList<Veterinar> doktori;
    private ArrayList<Pregled> pregledi;
    private Veterinar doktor1;
    private Veterinar doktor2;

    private Pregled preg1;
    private Pregled preg2;

    //konsturktor 
    public MainFrame() {
        super(20);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);

        setElements();

        getChildren().addAll(vbLevo, vbDesno);

        operativa();
    }

    private void setElements() {
        tgZivotinje = new ToggleGroup();
        radioPas = new RadioButton("Pas");
        radioPas.setToggleGroup(tgZivotinje);
        radioMacka = new RadioButton("Macka");
        radioMacka.setToggleGroup(tgZivotinje);
        radioPas.setSelected(true);
        hbTop = new HBox(50);
        hbTop.setAlignment(Pos.CENTER);
        hbTop.getChildren().addAll(radioPas, radioMacka);

        imeLab = new Label("Ime: ");
        starostLab = new Label("Starost: ");
        rasaLab = new Label("Rasa: ");
        masaLab = new Label("masa: ");
        vbLabels = new VBox(30);
        vbLabels.getChildren().addAll(imeLab, starostLab, rasaLab, masaLab);

        imeTf = new TextField();
        starostTf = new TextField();
        rasaTf = new TextField();
        masaTf = new TextField();
        vbTextFields = new VBox(20);
        vbTextFields.getChildren().addAll(imeTf, starostTf, rasaTf, masaTf);

        hbData = new HBox(30);
        hbData.getChildren().addAll(vbLabels, vbTextFields);

        dodajLjubimcaBtn = new Button("Dodaj Ljubimca U Red");

        tgDoktori = new ToggleGroup();
        radioDocLevo = new RadioButton("");
        radioDocLevo.setToggleGroup(tgDoktori);
        radioDocDesno = new RadioButton("");
        radioDocDesno.setToggleGroup(tgDoktori);
        radioDocLevo.setSelected(true);
        krajBtn = new Button("Kraj");
        krajBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                krajSmene();
            }
        });
        hbDoktori = new HBox(10);
        hbDoktori.setAlignment(Pos.CENTER);
        hbDoktori.getChildren().addAll(radioDocLevo, krajBtn, radioDocDesno);

        sledeciBtn = new Button("Prozovi Sledeceg Ljubimca");
        sledeciBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                prozoviSledeceg();
            }

        });

        gornjiVB = new VBox(10);
        gornjiVB.setAlignment(Pos.CENTER);
        gornjiVB.getChildren().addAll(hbTop, hbData, dodajLjubimcaBtn, hbDoktori, sledeciBtn);
        gornjiPane = new Pane();
        gornjiPane.getChildren().addAll(gornjiVB);

        ucitajJuceBtn = new Button("Ucitaj Red od Juce");
        ucitajJuceBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ucitajRedOdJuce();
            }
        });
        upisiZaSutraBtn = new Button("Sacuvaj Red Za Sutra");
        upisiZaSutraBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                upisiRedZaSutra();
            }
        });
        vbLevo = new VBox(10);
        vbLevo.setAlignment(Pos.CENTER);
        vbLevo.getChildren().addAll(gornjiPane, ucitajJuceBtn, upisiZaSutraBtn);

        taDesno = new TextArea("");
        taDesno.setEditable(false);
        taDesno.setPrefHeight(350);
        cbDoktori = new ComboBox();
        preglediDoktoraBtn = new Button("Pregledi Doktora");
        preglediDoktoraBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                prikaziPregledeDoktora();
            }

        });
        cekaonicaBtn = new Button("Cekaonica");
        cekaonicaBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ispisCekaonice();
            }
        });
        hbDesnoDole = new HBox(20);
        hbDesnoDole.setAlignment(Pos.CENTER);
        hbDesnoDole.getChildren().addAll(cbDoktori, preglediDoktoraBtn, cekaonicaBtn);
        vbDesno = new VBox(10);
        vbDesno.setAlignment(Pos.CENTER);
        vbDesno.getChildren().addAll(taDesno, hbDesnoDole);
    }

    private void prikaziPregledeDoktora() {
        Veterinar Vet = (Veterinar)cbDoktori.getSelectionModel().getSelectedItem();
        try {
            Scanner file = new Scanner(new File("pregledi.txt"));
            String str="";
            while(file.hasNext()){
                String linija = file.nextLine();
                //str += linija+"\n";
                if(linija.trim().length() == 0) continue;
                String []podaci = linija.split("; ");
                
                if(podaci.length>1 && podaci[1].equalsIgnoreCase(Vet.getIme())){
                
                    str += podaci[0]+"\n";
                }
            }
            file.close();
            taDesno.setText(str);
            
            
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
    }

    public void prozoviSledeceg() {
        if (radioDocLevo.isSelected()) {
            if (preg1 != null) {
                dodajMedjuPreglede(preg1);
            }
            if (ljubimci.size() > 0) {
                Date dat = new Date();
                Datum vreme = new Datum(dat.getDay(), dat.getMonth(), dat.getYear(), dat.getHours(), dat.getMinutes());
                preg1 = new Pregled(ljubimci.get(0), doktor1, vreme, "", 0.0);
                ljubimci.remove(0);
            } else {
                JOptionPane.showMessageDialog(null, "Nema nikog vise u cekaonici!");
                preg1 = null;
            }

        } else {
            if (preg2 != null) {
                dodajMedjuPreglede(preg2);
            }
            if (ljubimci.size() > 0) {
                Date dat = new Date();
                Datum vreme = new Datum(dat.getDay(), dat.getMonth(), dat.getYear(), dat.getHours(), dat.getMinutes());
                preg2 = new Pregled(ljubimci.get(0), doktor2, vreme, "", 0.0);
                ljubimci.remove(0);
            } else {
                JOptionPane.showMessageDialog(null, "Nema nikog vise u cekaonici!");
                preg2 = null;
            }
        }
        ispisCekaonice();
    }

    private void krajSmene() {
        if (radioDocLevo.isSelected()) {
            if (preg1 != null) {
                dodajMedjuPreglede(preg1);
            }
            preg1 = null;
        } else {
            if (preg2 != null) {
                dodajMedjuPreglede(preg2);
            }
            preg2 = null;
        }
        ispisCekaonice();
    }

    public void upisiRedZaSutra() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("ljubimci.txt")));
            for (Ljubimac Lj : ljubimci) {
                bw.append(Lj.toFile());
                bw.newLine();
            }
            bw.flush();
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        upisiZaSutraBtn.setDisable(true);
        ucitajJuceBtn.setDisable(false);
        ugasiKomponente(true);
        if (preg1 != null) {
            dodajMedjuPreglede(preg1);
            preg1 = null;
        }
        if (preg2 != null) {
            dodajMedjuPreglede(preg2);
            preg2 = null;
        }
        ljubimci.clear();
        taDesno.setText("");
    }

    public void ucitajRedOdJuce() {
        ucitajLjubimce();
        ispisCekaonice();
        ugasiKomponente(false);
        ucitajJuceBtn.setDisable(true);
        upisiZaSutraBtn.setDisable(false);
    }

    private void operativa() {
        preg1 = null;
        preg2 = null;
        pregledi = new ArrayList<>();

        ucitajDoktore();
        radioDocLevo.setText("Dr " + doktor1.getIme());
        radioDocDesno.setText("Dr " + doktor2.getIme());
        ugasiKomponente(true);
    }

    private void ucitajDoktore() {
        doktori = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File("doktori.txt"));
            String linija = "";
            while (file.hasNext()) {
                linija = file.nextLine();
                Veterinar Vet = new Veterinar(linija);
                doktori.add(Vet);
                cbDoktori.getItems().add(Vet);
            }
            file.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        Random rand = new Random();
        int ind1 = rand.nextInt(doktori.size());
        int ind2;
        do {
            ind2 = rand.nextInt(doktori.size());
        } while (ind1 == ind2);
        doktor1 = doktori.get(ind1);
        doktor2 = doktori.get(ind2);
    }

    private void ugasiKomponente(boolean flag) {
        for (Node node : gornjiPane.getChildren()) {
            node.setDisable(flag);
        }
    }

    private void ispisCekaonice() {
        String str = "";
        if (preg1 != null) {
            str += preg1 + "\n";
        }
        if (preg2 != null) {
            str += preg2 + "\n";
        }
        str += "U redu cekaju:\n";
        int br = 1;
        for (Ljubimac Lj : ljubimci) {
            str += br + ": " + Lj + "\n";
            br++;
        }
        taDesno.setText(str);
    }

    private void ucitajLjubimce() {
        ljubimci = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File("ljubimci.txt"));
            String linija = "";
            while (file.hasNext()) {
                try {
                    linija = file.nextLine();
                    if (linija.trim().length() == 0) {
                        continue;//preskoci ako je prazna linija.
                    }
                    String[] podaci = linija.split(", ");
                    if (podaci[0].equalsIgnoreCase("P")) {
                        if (Pas.verifikacijaSifre(podaci[5]) == false) {
                            throw new PogresnaSifraException("Nije dobra sifra za psa> " + linija);
                        }
                        ljubimci.add(new Pas(podaci[1], Integer.parseInt(podaci[3]), podaci[2], podaci[5], Double.parseDouble(podaci[4])));
                    } else {
                        if (Macka.verifikacijaSifre(podaci[4]) == false) {
                            throw new PogresnaSifraException("Nije dobra sifra za macku> " + linija);
                        }
                        ljubimci.add(new Macka(podaci[1], Integer.parseInt(podaci[3]), podaci[2], podaci[4]));
                    }
                } catch (PogresnaSifraException psex) {
                    psex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            file.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void dodajMedjuPreglede(Pregled preg) {
        try {
            String Opis = JOptionPane.showInputDialog("Doktore " + preg.getDoktor().getIme() + ", opisite pregled:");
            double cena = Double.parseDouble(JOptionPane.showInputDialog("Doktore " + preg.getDoktor().getIme() + ", Unesite Cenu:"));
            preg.setCena(cena);
            preg.setOpis(Opis);

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("pregledi.txt"), true));//true znaci da se dodaje na kraj.
            bw.append(preg.ToFile());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
