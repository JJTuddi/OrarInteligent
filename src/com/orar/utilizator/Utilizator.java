package com.orar.utilizator;

import com.orar.conexiuneBD.Conexiune;
import com.orar.conexiuneBD.Materii;
import com.orar.timp.Timp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Utilizator implements Initializable {
    public Text oTextZiua, oText1, oText2, oText3;
    public Rectangle o8, o9, o10, o11, o12, o13, o14, o15, o16, o17, o18, o19, o20, o21, o22;
    public Text oTextOra8, oTextOra9, oTextOra10, oTextOra11, oTextOra12, oTextOra13, oTextOra14, oTextOra15, oTextOra16, oTextOra17, oTextOra18, oTextOra19, oTextOra20, oTextOra21, oTextOra22;
    public Pane paneOrar, paneMateriiCurente, paneAdaugareMaterie, paneRenuntareMaterie;
    public Text cerc_mc, cerc_o, cerc_rm, cerc_am, cerc_p;
    public ChoiceBox<Materii> choiceBox_mc, choiceBox_am, choiceBox_rm;
    public Text mesajSucces_am, mcDenumire, mcTimp, mcTipMaterieSiCuCine, mcNrCredite, mcAiNota, mesajEroare_am, succesNota_mc, eroareNota_mc, mesaj_rm;
    public TextField fieldNota_mc;

    private void resetChoiceBoxRM() {
        choiceBox_rm.getItems().clear();
        ArrayList<Materii> materii = Conexiune.getConexiune().getMateriiUser();
        for (Materii materie: materii) {
            choiceBox_rm.getItems().add(materie);
        }
    }

    private void resetareCercuri() {
        cerc_am.fillProperty().setValue(Paint.valueOf("#000000"));
        cerc_mc.fillProperty().setValue(Paint.valueOf("#000000"));
        cerc_o.fillProperty().setValue(Paint.valueOf("#000000"));
        cerc_rm.fillProperty().setValue(Paint.valueOf("#000000"));
        cerc_p.fillProperty().setValue(Paint.valueOf("#000000"));

        // si nu numai
        mcDenumire.setText("");
        mcTimp.setText("");
        mcTipMaterieSiCuCine.setText("");
        mcNrCredite.setText("");
        mcAiNota.setText("");
    }

    public Rectangle getRectangleByNumber(int n) {
        if (n == 8) {
            return o8;
        } else if (n == 9) {
            return o9;
        } else if (n == 10) {
            return o10;
        } else if (n == 11) {
            return o11;
        } else if (n == 12) {
            return o12;
        } else if (n == 13) {
            return o13;
        } else if (n == 14) {
            return o14;
        } else if (n == 15) {
            return o15;
        } else if (n == 16) {
            return o16;
        } else if (n == 17) {
            return o17;
        } else if (n == 18) {
            return o18;
        } else if (n == 19) {
            return o19;
        } else if (n == 20) {
            return o20;
        } else if (n == 21) {
            return o21;
        } else if (n == 22) {
            return o22;
        }
        return null;
    }

    public void resetRectangles() {
        for (int i = 8; i <= 22; i++) {
            getRectangleByNumber(i).fillProperty().setValue(Paint.valueOf("#A8DADC"));
        }
    }

    private ArrayList<Integer> getOreOcupate() {
        ArrayList<Materii> materiiCurente = Conexiune.getConexiune().getMateriiUser();
        ArrayList<Integer> oreOcupate = new ArrayList<Integer>();
        Timp timp = new Timp();
        for (Materii materie : materiiCurente) {
            if (materie.getZi() == timp.getnDay()) {
                for (int i = 0; i < materie.getDurata(); i++) {
                    oreOcupate.add(materie.getOraInceput() + i);
                }
            }
        }
        return oreOcupate;
    }

    private void resetOre() {
        oTextOra8.setText("08:00-09:00");
        oTextOra9.setText("09:00-10:00");
        oTextOra10.setText("10:00-11:00");
        oTextOra11.setText("11:00-12:00");
        oTextOra12.setText("12:00-13:00");
        oTextOra13.setText("13:00-14:00");
        oTextOra14.setText("14:00-15:00");
        oTextOra15.setText("15:00-16:00");
        oTextOra16.setText("16:00-17:00");
        oTextOra17.setText("17:00-18:00");
        oTextOra18.setText("18:00-19:00");
        oTextOra19.setText("19:00-20:00");
        oTextOra20.setText("20:00-21:00");
        oTextOra21.setText("21:00-22:00");
        oTextOra22.setText("22:00-23:00");
    }

    private Text getOraDupaNumar(int n) {
        if (n == 8) {
            return oTextOra8;
        } else if (n == 9) {
            return oTextOra9;
        } else if (n == 10) {
            return oTextOra10;
        } else if (n == 11) {
            return oTextOra11;
        } else if (n == 12) {
            return oTextOra12;
        } else if (n == 13) {
            return oTextOra13;
        } else if (n == 14) {
            return oTextOra14;
        } else if (n == 15) {
            return oTextOra15;
        } else if (n == 16) {
            return oTextOra16;
        } else if (n == 17) {
            return oTextOra17;
        } else if (n == 18) {
            return oTextOra18;
        } else if (n == 19) {
            return oTextOra19;
        } else if (n == 20) {
            return oTextOra20;
        } else if (n == 21) {
            return oTextOra21;
        } else if (n == 22) {
            return oTextOra22;
        }
        return null;
    }

    private void setDetaliiOrar() {
        Timp t = new Timp();
        ArrayList<Materii> materii = Conexiune.getConexiune().getMateriiUser();
        boolean oraOcupata = false;
        for (Materii materie: materii) {
            if (materie.getZi() == t.getnDay()) {
                if (materie.getOraInceput() <= t.getHour() && materie.getDurata() + materie.getOraInceput() - 0.01 >= t.getHour()) {
                    oraOcupata = true;
                    oText1.setText("Acum ai ora de " + materie.getDenumireMaterie());
                    oText2.setText("Predata de " + materie.getNumeProfesor());
                    oText3.setText("Recomand sa fii atent!");
                }
            }
        }
        if (!oraOcupata) {
            oText1.setText("Esti liber, mergi la sectiunea Pomodoro si invata!");
            oText2.setText("");
            oText3.setText("");
        }
    }

    private void setOrarCurent(Timp t) {
        // #FAAEBB -- oraCurenta
        // #FF508C -- ocupat
        // #A8DADC -- liber
        resetOre();
        resetRectangles();
        ArrayList<Integer> oreOcupate = getOreOcupate();
        for (Integer ora : oreOcupate) {
            getRectangleByNumber(ora).fillProperty().setValue(Paint.valueOf("#FF508C"));
        }
        getOraDupaNumar(t.getHour()).setText(t.getHour() + " - Ora curenta");
        oTextZiua.setText(Timp.numeZi(t.getnDay()));
        getRectangleByNumber(t.getHour()).fillProperty().setValue(Paint.valueOf("#FAAEBB"));
    }

    private void adaugareMateriiCurente() {
        ArrayList<Materii> materiiCurente = Conexiune.getConexiune().getMateriiUser();
        choiceBox_mc.getItems().clear();
        for (Materii materie : materiiCurente) {
            choiceBox_mc.getItems().add(materie);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mesajSucces_am.setText("");
        mesaj_rm.setText("");
        adaugareMateriiCurente();
        succesNota_mc.setText("");
        eroareNota_mc.setText("");
        mesajEroare_am.setText("");
        Timp t = new Timp();
        ArrayList<Materii> materii = Conexiune.getConexiune().getMaterii();
        choiceBox_am.getItems().clear();
        for (Materii materie : materii) {
            choiceBox_am.getItems().add(materie);
        }
        setOrarCurent(t);
    }

    public void butonOrar() {
        paneOrar.toFront();
        resetareCercuri();
        cerc_o.fillProperty().setValue(Paint.valueOf("#FF508C"));
        Timp t = new Timp();
        setDetaliiOrar();
        setOrarCurent(t);
    }

    public void butonMaterii() {
        paneMateriiCurente.toFront();
        resetareCercuri();
        cerc_mc.fillProperty().setValue(Paint.valueOf("#FF508C"));
        adaugareMateriiCurente();
    }

    public void butonAdaugareMaterii() {
        paneAdaugareMaterie.toFront();
        resetareCercuri();
        cerc_am.fillProperty().setValue(Paint.valueOf("#FF508C"));
    }

    public void actualizareDetaliiMaterieCurenta() {
        if (choiceBox_mc.getValue() != null) {
            mcDenumire.setText("(" + choiceBox_mc.getValue().getPrescurtare() + "):" + choiceBox_mc.getValue().getDenumireMaterie());
            mcTimp.setText("Are loc " + Timp.numeZi(choiceBox_mc.getValue().getZi()) + ", de la ora " + choiceBox_mc.getValue().getOraInceput() + " si dureaza " + choiceBox_mc.getValue().getDurata() + " ore");
            mcTipMaterieSiCuCine.setText("Este " + choiceBox_mc.getValue().getDenumireActivitate());
            if (choiceBox_mc.getValue().getNumarCredite() != 0) {
                mcNrCredite.setText("Valoreaza " + choiceBox_mc.getValue().getNumarCredite() + " credite ");
            } else {
                mcNrCredite.setText("Vezi la materia de curs cate credite are");
            }
            if (choiceBox_mc.getValue().getNota() == 0) {
                mcAiNota.setText("Momentan nu ai nota trecuta la aceasta materie, poti sa o treci");
            } else {
                mcAiNota.setText("Ai nota " + choiceBox_mc.getValue().getNota());
            }
        }
    }

    public void btAdaugareMatInOrar() {
        mesajSucces_am.setText("");
        mesajEroare_am.setText("");
        if (choiceBox_am.getValue() != null) {
            Conexiune.getConexiune().assignStudentLaMaterie(choiceBox_am.getValue());
            mesajSucces_am.setText("Felicitari, ti-ai adaugat in orar materia " + choiceBox_am.getValue().toString());
            adaugareMateriiCurente();
        } else {
            mesajEroare_am.setText("*Te rog sa alegi o materie!");
        }
    }

    public void delogare(ActionEvent ae) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../autentificare/autentificare.fxml"));
        Stage currentStage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        currentStage.setScene(new Scene(root, 1090, 453));
        currentStage.show();
    }

    public void butonSetareNota_mc() {
        succesNota_mc.setText("");
        eroareNota_mc.setText("");
        if (choiceBox_mc.getValue() != null) {
            String nota = fieldNota_mc.getText();
            if (isNumber(nota)) {
                int value = Integer.parseInt(nota);
                if (value <= 10 && value >= 0) {
                    Conexiune.getConexiune().setareNota(choiceBox_mc.getValue(), value);
                    if (value > 0) {
                        mcAiNota.setText("Ai nota " + value);
                    } else {
                        mcAiNota.setText("Momentan nu ai nota trecuta la aceasta materie, poti sa o treci");
                    }
                    succesNota_mc.setText("Nota a fost setata!");
                } else {
                    eroareNota_mc.setText("Nota trebuie sa fie intre 0 si 10 inclusiv!");
                }
            } else {
                eroareNota_mc.setText("*Eroare la setarea notei, asigura-te ca ai introdus un numar intreg!");
            }
        } else {
            eroareNota_mc.setText("*Te rog sa alegi o materie!");
        }
    }

    public boolean isNumber(String s) {
        try {
            int value = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void butonRenuntareMaterie() {
        mesaj_rm.setText("");
        resetChoiceBoxRM();
        paneRenuntareMaterie.toFront();
        resetareCercuri();
        cerc_rm.fillProperty().setValue(Paint.valueOf("#FF508C"));
    }

    public void butonRenuntare(){
        if (choiceBox_rm.getValue() != null) {
            String numeMaterie = choiceBox_rm.getValue().toString();
            Conexiune.getConexiune().renuntareLaMaterie(choiceBox_rm.getValue());
            mesaj_rm.setText("Ai renuntat la " + numeMaterie);
        }
        resetChoiceBoxRM();
    }

    public void resetareOrar() {
        Conexiune.getConexiune().resetareOrar();
        resetChoiceBoxRM();
        adaugareMateriiCurente();
        mesaj_rm.setText("Ai renuntat la toate materiile pe care le aveai in orar!");
    }
}
