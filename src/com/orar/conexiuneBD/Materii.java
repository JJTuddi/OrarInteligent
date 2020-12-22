package com.orar.conexiuneBD;

public class Materii {
    private int idMaterie, zi, oraInceput, durata, numarCredite, nota;
    private String denumireMaterie, prescurtare, numeProfesor, denumireActivitate;

    public int getIdMaterie() {
        return idMaterie;
    }

    public void setIdMaterie(int idMaterie) {
        this.idMaterie = idMaterie;
    }

    public int getZi() {
        return zi;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public int getOraInceput() {
        return oraInceput;
    }

    public void setOraInceput(int oraInceput) {
        this.oraInceput = oraInceput;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getNumarCredite() {
        return numarCredite;
    }

    public void setNumarCredite(int numarCredite) {
        this.numarCredite = numarCredite;
    }

    public String getDenumireMaterie() {
        return denumireMaterie;
    }

    public void setDenumireMaterie(String denumireMaterie) {
        this.denumireMaterie = denumireMaterie;
    }

    public String getPrescurtare() {
        return prescurtare;
    }

    public void setPrescurtare(String prescurtare) {
        this.prescurtare = prescurtare;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public void setNumeProfesor(String numeProfesor) {
        this.numeProfesor = numeProfesor;
    }

    public String getDenumireActivitate() {
        return denumireActivitate;
    }

    public void setDenumireActivitate(String denumireActivitate) {
        this.denumireActivitate = denumireActivitate;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return denumireMaterie + "(" + denumireActivitate + ") intre " + oraInceput + ":00-" + (oraInceput + durata) + ":00 (" + numeProfesor + ")" ;
    }
}