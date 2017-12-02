/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Dyah Ayu Shafitri
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> Kodelist = FXCollections.observableArrayList("JTIM","JTENG","JBAR");
    ObservableList<String> Kelaslist = FXCollections.observableArrayList("ekonomi","bisnis","eksekutif");

    @FXML
    private TextField nama;

    @FXML
    private TextField id;

    @FXML
    private TextField namakereta;
      @FXML
    private ChoiceBox<String> kode;
          @FXML
    private ChoiceBox<String> kelas;

    @FXML
    private RadioButton ekonomi;

    @FXML
    private RadioButton bisnis;

    @FXML
    private RadioButton eksekutif;

    @FXML
    private TextField beragkat;

    @FXML
    private TextField tujuan;

    @FXML
    private TextField harga;

    @FXML
    private TextField jumlah;

    @FXML
    private TextField harga1;
      @FXML
    private DatePicker tglb;

    @FXML
    private DatePicker tglk;
    @FXML
    private Button exit;

    @FXML
    private Button reset;

    @FXML
    private Button buy;
    
    @FXML
    private Button Hitung;
    
    String Nama,Noid,Kode,Kelas,Namakereta,Berangkat,Tglber,Tujuan,Tglked,Jumlah,Harga,Total;

    ObservableList<String> KodeList = FXCollections.observableArrayList("JTIM","JTENG","JBAR");
     ObservableList<String> KelasList = FXCollections.observableArrayList("Ekonomi","Bisnis","Eksekutif");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kode.setValue("Pilih Kode");
        kode.setItems(KodeList);
        kelas.setValue("Pilih Kode");
        kelas.setItems(KelasList);
        
        
    }    

    void Kirim(){
        
        //untuk validasi isian
        
         if(nama.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap inputkan Nama Anda");
        }else if (id.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap isikan No ID Anda");
        }else if(kode.getValue().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap inputkan Kode Kereta ");
        }else if(kelas.getValue().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap inputkan Kelas Kereta ");
        }else if(namakereta.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap inputkan Nama Kereta");
        }else if(beragkat.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap isi Data Stasiun Keberangkatan");
        }else if(tujuan.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap isi Data Stasiun Tujuan");
        }else if(tglb.getValue().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap pilih Tanggal Berangkat");
        }else if(tglk.getValue().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap pilih Tanggal Kedatangan");
        }else if(jumlah.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap isikan Jumlah Pembelian Tiket");
         }else if(harga.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap isikan Harga Tiket ");
         }else if(harga1.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Harap isikan Total Harga Tiket");
         }
        //untuk pengambilan nilai isian
       Nama = nama.getText();
       Noid = id.getText();
       Kode = kode.getValue().toString();
       Namakereta = namakereta.getText(); 
       Kelas = kelas.getValue().toString();
       Berangkat = beragkat.getText();
       Tglber = tglb.getValue().toString();
       Tujuan = tujuan.getText();
       Tglked = tglk.getValue().toString();
       Jumlah = jumlah.getText();
       Harga = harga.getText();
       Total = harga1.getText();
       
        
    }
    
   @FXML
    private void Buy(ActionEvent event) throws IOException {
        
        Kirim();//akan memanggil menjalankan method Kirim
        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("nota.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Nota TICker");
            stage.show();
            
            NotaController Data= new NotaController ();
            Data = fxmlLoader.getController();
            ChoiceBox<String> kelas = null;
            
            Data.setdata(Nama, Noid, Kode, Namakereta ,Kelas, Berangkat,Tglber,Tujuan,Tglked,Jumlah,Harga,Total);
            
        } catch (IOException e) {
            System.out.println("Batal membuat window baru" + e);
        }
        
    }

    

    @FXML
    void Exit(ActionEvent event) throws IOException {
        System.exit(0);
    }


    @FXML
    private void Reset(ActionEvent event) {
        nama.setText("");
        id.setText("");
        namakereta.setText("");
        beragkat.setText("");
       tujuan.setText("");
        harga.setText("");
        harga1.setText("");
        jumlah.setText("");
      
       kode.setValue("---Pilih Kode---");
        tglb.setValue(LocalDate.MAX);
      tglk.setValue(LocalDate.MAX);
    }
     @FXML
    void hitung(ActionEvent event) {
        int a1=Integer.parseInt(jumlah.getText());
        int a2=Integer.parseInt(harga.getText());
        
        int total = a1*a2;
        harga1.setText(" "+total);
    }
    private void setdata(TextField nama, TextField id, ChoiceBox<String> kode, TextField namakereta, ChoiceBox<String> kode0, TextField beragkat, TextField tujuan, DatePicker tglb, DatePicker tglk, TextField jumlah, TextField harga, TextField harga1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setdata(String Nama, String Noid, String Kode, String Namakereta, String Kelas, String Berangkat, String Tujuan, String Tglber, String Tglked, String Jumlah, String Harga, String Total) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
