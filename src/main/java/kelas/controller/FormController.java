package kelas.controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas.data.DataPembelian;
import kelas.model.*;

public class FormController {

    @FXML
    private TextField namaField, jumlahField;
    @FXML
    private ComboBox<String> jenisBox;
    @FXML
    private Label pesanLabel, gambarLabel;
    private Navigator navigator;
    private DataPembelian data;
    private String gambarDipilih;

    @FXML
    private void initialize() {
        jenisBox.getItems().addAll("Makanan", "Minuman");
        jenisBox.setValue("Makanan");
    }

    public void setKonteks(Navigator navigator, DataPembelian data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void pilihGambar() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Pilih Gambar Produk");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Gambar", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"));
        File file = fc.showOpenDialog(namaField.getScene().getWindow());
        if (file != null) {
            gambarDipilih = file.toURI().toString();
            gambarLabel.setText(file.getName());
        }
    }

    @FXML
    private void simpan() {
        Produk p;
        try {
            int harga = Integer.parseInt(jumlahField.getText().trim());
            p = data.tambah(namaField.getText(), jenisBox.getValue(), harga);
            p.setGambar(gambarDipilih);
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga harus bilangan bulat dalam rentang int positif.");
            return;
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
            return;
        }
        try {
            navigator.bukaDetail(p);
        } catch (IOException e) {
            data.hapus(p);
            pesanLabel.setText("Halaman detail gagal dibuka; data dibatalkan. Periksa FXML.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar.");
            e.printStackTrace();
        }
    }
}
