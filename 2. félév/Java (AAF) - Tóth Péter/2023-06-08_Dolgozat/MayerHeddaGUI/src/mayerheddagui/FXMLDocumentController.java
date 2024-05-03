package mayerheddagui;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ChoiceBox<String> targy;

    @FXML
    private TextField jegy;

    @FXML
    private TextField nev;

    @FXML
    void click(ActionEvent event) {
        try {
            File file = new File("adatok.txt");
            if(file.createNewFile()) {
            } else {
                System.out.println("A fájl már létezik!");
            }
            
            FileWriter fw = new FileWriter("adatok.txt");
            fw.write(this.nev.getText() + ";" + this.targy.getValue() + ";" + this.jegy.getText());
            
            fw.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.targy.getItems().addAll("Webprogramozás", "Adatbáziskezelés", "Programozás alapok");
    }    
    
}
