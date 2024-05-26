/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meccskereso2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author peter
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label eredmeny;
    
    @FXML
    private Label idopont;

    @FXML
    private ChoiceBox<String> vendegList;

    @FXML
    private Button btn;

    @FXML
    private ChoiceBox<String> hazaiList;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        ArrayList<Meccs> adatok = read();
        
        boolean voltTalalat = false;
        for(Meccs m : adatok){
            if(m.getHazai().equals(this.hazaiList.getValue()) && m.getVendeg().equals(this.vendegList.getValue())){
                this.eredmeny.setText(m.getLott() + " - " + m.getKapott());
                this.idopont.setText(m.getIdopont().toString());
                voltTalalat = true;
                break;
            }
        }
        
        if(!voltTalalat){
            this.eredmeny.setText("Nincs adat");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //3. Töltse fel a legördülő mezőket az alábbi adatokkal:

        String[] cs = {"Ajax",
        "Atletico Madrid",
        "Barcelona",
        "Bayern Munich",
        "Liverpool",
        "Manchester United",
        "Napoli",
        "Tottenham Hotspur"
                };
        ArrayList<String> lista= new ArrayList(Arrays.asList(cs));
        
        for(String s : lista){
            this.hazaiList.getItems().add(s);
            this.vendegList.getItems().add(s);
        }
        
    }    
    
    public static ArrayList<Meccs> read(){
        ArrayList<Meccs> adatok = new ArrayList<>();
        try {
            
            File file = new File("football.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine(); //Első sor átugrása, mert abban a fejlécek szerepelnek
            while(sc.hasNextLine()){
                adatok.add(new Meccs(sc.nextLine()));
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        return adatok;
    }
    
}
