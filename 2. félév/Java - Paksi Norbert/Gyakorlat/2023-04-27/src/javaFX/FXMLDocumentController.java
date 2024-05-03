/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author eepseelona
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField aNumber;

    @FXML
    private Label label;

    @FXML
    private TextField bNumber;

    @FXML
    private TextField resultNumber;

    @FXML
    void addNumbers(ActionEvent event) {
        int aNumber = Integer.parseInt(aNumber.getText());
    }

    @FXML
    void subNumbers(ActionEvent event) {

    }

    @FXML
    void multiNumbers(ActionEvent event) {

    }

    @FXML
    void divNumbers(ActionEvent event) {

    }

}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
