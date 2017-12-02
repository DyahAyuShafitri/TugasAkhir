/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dyah Ayu Shafitri
 */
public class AwalController implements Initializable {

    @FXML
    private Button btnrute;
    @FXML
    private Button btn;
        @FXML
    private Button harga;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rute(ActionEvent event) throws IOException{
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("peta.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 675, 524);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Peta TICker");
            stage.show();
    }
        @FXML
    void Harga(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("harga.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 754, 659);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Daftar Harga TICker");
            stage.show();

    }

    @FXML
    private void button(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 722, 618);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Booking TICker");
            stage.show();
    }
    
}
