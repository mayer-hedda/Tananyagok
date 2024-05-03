/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author gapz
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField torlonyomas;

    @FXML
    private TextArea eredmeny;

    @FXML
    private TextField statikusnyomas;

    @FXML
    void szamol(ActionEvent event) {
        Double qc = Double.parseDouble(torlonyomas.getText());
        Double p0 = Double.parseDouble(statikusnyomas.getText());
        
        // gyökvonás
        Double qcGyok = Math.sqrt(qc);
        
        // hatványozás
        double hatvany = Math.pow(2, 2.0/7.0);
        
        String elozoSzoveg = eredmeny.getText();
        eredmeny.setText(elozoSzoveg + "Eredmény:" + qc/p0 + "Gyök" + qcGyok + "HATVANY: " + hatvany + "\n");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
