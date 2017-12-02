/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

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


/**
 * FXML Controller class
 *
 * @author Dyah Ayu Shafitri
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button btnlogin;
    @FXML
    private Button btnsignup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
       Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/tugasakhir?zeroDate TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `login` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
              JOptionPane.showMessageDialog(null, "Sukses Login");
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("awal.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 487, 310);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Welcome Ticker");
            stage.show();
          
            } else {
                JOptionPane.showMessageDialog(null, "Salah!");
                username.setText("");
                password.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal!");
        }
    }

    @FXML
    private void signup(ActionEvent event)throws IOException {
       
        try {
           ((Node)(event.getSource())).getScene().getWindow().hide();
           
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 448, 276);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sign Up TICker");
            stage.show();
          
        } catch (IOException e) {
            System.out.println("Failed to create new window." + e);
        }
    }
}

