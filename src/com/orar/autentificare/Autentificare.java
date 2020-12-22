package com.orar.autentificare;

import com.orar.conexiuneBD.Conexiune;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Autentificare implements Initializable {
    public TextField autentificareUsername;
    public PasswordField autentificareParola;
    public Button autentificareButon_i, autentificareButon_a;
    public Text autentificareMesajEroare;
    public Pane paneAutentificare, paneInregistrare;


    public TextField inregistrareNume, inregistrarePrenume, inregistrareMail, inregistrareUsername;
    public PasswordField inregistrareParola;
    public Button inregistrareButon_a, inregistrareButon_i;
    public Text inregistrareMesajEroare, inregistrareMesajSucces;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetareFielduri();
    }

    public void AutentifAutentificare (ActionEvent actionEvent) throws IOException {
        if (autentificareUsername.getText().length() >= 16 || autentificareParola.getText().length() >= 16 || autentificareParola.getText().length() < 4 || autentificareUsername.getText().length() < 4) {
            resetareFielduri();
            autentificareMesajEroare.setText("*Parola sau Username scurte/prea lungi!");
        } else {
            if (Conexiune.getConexiune().setUser(autentificareUsername.getText(), autentificareParola.getText())) {
                schimbaFereastra(actionEvent);
            } else {
                resetareFielduri();
                autentificareMesajEroare.setText("*Nume sau parola incorecte!");
            }
        }
    }

    public void AutentifInregistrare() {
        resetareFielduri();
        paneInregistrare.toFront();
    }

    public void schimbaFereastra(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../utilizator/utilizator.fxml"));
        Stage currentStage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        currentStage.setScene(new Scene(root, 1280, 720));
        currentStage.show();
    }

    public void resetareFielduri() {
        autentificareMesajEroare.setText("");
        autentificareUsername.setText("");
        autentificareParola.setText("");
        inregistrareNume.setText("");
        inregistrarePrenume.setText("");
        inregistrareMail.setText("");
        inregistrareUsername.setText("");
        inregistrareParola.setText("");
        inregistrareMesajEroare.setText("");
        inregistrareMesajSucces.setText("");
    }

    public void InregAutentificare() {
        resetareFielduri();
        paneAutentificare.toFront();

    }

    public void InregInregistrare() {
        if (inregistrareNume.getText().length() >= 32 || inregistrarePrenume.getText().length() >= 64 || inregistrareMail.getText().length() >= 128 || inregistrareUsername.getText().length() >= 16 || inregistrareParola.getText().length() >= 16 ||
            inregistrareNume.getText().length() < 2 || inregistrarePrenume.getText().length() < 2 || inregistrareMail.getText().length() < 4 || inregistrareUsername.getText().length() < 4 || inregistrareParola.getText().length() < 4) {
            resetareFielduri();
            inregistrareMesajEroare.setText("*Date invalide pentru inregistrare!");
        } else {
            // inregistrare(String email, String username, String parola, String nume, String prenume)
            if (Conexiune.getConexiune().inregistrare(inregistrareMail.getText(), inregistrareUsername.getText(), inregistrareParola.getText(), inregistrareNume.getText(), inregistrarePrenume.getText())) {
                resetareFielduri();
                inregistrareMesajSucces.setText("Inregistrare cu succes!");
            } else {
                resetareFielduri();
                inregistrareMesajEroare.setText("*Username sau e-mail deja folosite!");
            }
        }
    }

}
