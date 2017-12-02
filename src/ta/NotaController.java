/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static com.sun.javafx.application.PlatformImpl.exit;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.Global.exit;

/**
 * FXML Controller class
 *
 * @author Dyah Ayu Shafitri
 */
public class NotaController implements Initializable {

    @FXML
    private JFXTextField nama;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField kode;
    @FXML
    private JFXTextField namakereta;
    @FXML
    private JFXTextField kelas;
    @FXML
    private JFXTextField keberangkatan;
    @FXML
    private JFXTextField tujuan;
    @FXML
    private JFXTextField jumlah;
    @FXML
    private JFXTextField harga;
    @FXML
    private JFXTextField total;
    @FXML
    private JFXButton btnexit;
    @FXML
    private JFXTextField tglb;

    @FXML
    private JFXTextField tglk;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void setdata(String Nama, String Id, String Kode, String Namakereta, String Kelas, String Keberangkatan, String Tujuan, String Jumlah,String Harga ,String Total,String Tglk,String Tglb){
        nama.setText(Nama);
        id.setText(Id);
        kode.setText(Kode);
        namakereta.setText(Namakereta);
        kelas.setText(Kelas);
        keberangkatan.setText(Keberangkatan);
        tglb.setText(Tglb);
        tujuan.setText(Tujuan);
         tglk.setText(Tglk);
        jumlah.setText(Jumlah);
        harga.setText(Harga);
        total.setText(Total);
    }

    @FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) btnexit.getScene().getWindow();
        stage.close();
    }
    
}
