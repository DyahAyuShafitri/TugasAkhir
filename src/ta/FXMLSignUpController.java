/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.fxml.LoadException;

/**
 * FXML Controller class
 *
 * @author Dyah Ayu Shafitri
 */
public class FXMLSignUpController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private Button btndaftar;
    @FXML
    private TextField password;
    @FXML
    private Button btnexit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void daftar(ActionEvent event) {
        Connection connection;
        PreparedStatement pr;
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir","root","");
            pr=(PreparedStatement) connection.prepareStatement("INSERT INTO login(username,password) VALUES(?,?)");
            pr.setString(1,username.getText());
            pr.setString(2,password.getText());
            pr.execute();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Daftar Gagal");
        }
    }

    @FXML
    private void exit(ActionEvent event) throws IOException {
        try{
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 448, 276);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Login Ticker");
            stage.show();
    }
        catch (IOException e){
            System.out.println("Failed to create new Window." + e);
        }
    }
    
}