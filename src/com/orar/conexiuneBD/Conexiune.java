package com.orar.conexiuneBD;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class Conexiune {
    private User curent;
    Connection connection = null;
    Statement selectStatement = null, interrogationStatement = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    private static Conexiune c = new Conexiune();

    private Conexiune() {
        curent = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Negasit!");
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orar", "root", "tuddiroot");
            selectStatement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("Erori in interogarea bazei de date!");
        }
    }

    public static Conexiune getConexiune() {
        return c;
    }

    public boolean setUser(String username, String passowrd) {
        curent = new User();
        boolean result = false;
        try{
            rs = selectStatement.executeQuery("SELECT * FROM users WHERE parola = '" + passowrd + "' AND username = '" + username + "';");
            rs.next();
            curent.setIdUser(rs.getInt(1));
            curent.setEmail(rs.getString(2));
            curent.setUsername(rs.getString(3));
            curent.setParola(rs.getString(4));
            curent.setNume(rs.getString(5));
            curent.setPrenume(rs.getString(6));
            result = true;
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return result;
    }

    public User getUser() {
        return curent;
    }

    public ArrayList<Materii> getMaterii() {
        ArrayList<Materii> result = new ArrayList<Materii>();
        try {
            rs = selectStatement.executeQuery("SELECT * FROM vMaterii;");
            while (rs.next()) {
                Materii materie = new Materii();
                materie.setIdMaterie(rs.getInt(1));
                materie.setDenumireMaterie(rs.getString(2));
                materie.setPrescurtare(rs.getString(3));
                materie.setZi(rs.getInt(4));
                materie.setOraInceput(rs.getInt(5));
                materie.setDurata(rs.getInt(6));
                materie.setNumarCredite(rs.getInt(7));
                materie.setNumeProfesor(rs.getString(8));
                materie.setDenumireActivitate(rs.getString(9));
                result.add(materie);
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            //throwables.printStackTrace();
        }
        return result;
    }

    public ArrayList<Materii> getMateriiUser() {
        ArrayList<Materii> result = new ArrayList<Materii>();
        String statement = new String("SELECT m.id_materie, m.denumire_materie, m.prescurtare, m.zi, m.ora_inceput, m.durata, m.numar_credite, m.nume_profesor, m.denumire_activitate, um.nota FROM vMaterii m JOIN users_materii um JOIN users u ON um.id_materie = m.id_materie AND u.id_user = um.id_user WHERE u.id_user = " + curent.getIdUser() + ";");
        System.out.println(statement);
        try{
            rs = selectStatement.executeQuery(statement);
            while(rs.next()) {
                Materii materie = new Materii();
                materie.setIdMaterie(rs.getInt(1));
                materie.setDenumireMaterie(rs.getString(2));
                materie.setPrescurtare(rs.getString(3));
                materie.setZi(rs.getInt(4));
                materie.setOraInceput(rs.getInt(5));
                materie.setDurata(rs.getInt(6));
                materie.setNumarCredite(rs.getInt(7));
                materie.setNumeProfesor(rs.getString(8));
                materie.setDenumireActivitate(rs.getString(9));
                materie.setNota(rs.getInt(10));
                result.add(materie);
            }
        } catch (SQLException throwables) {
            System.out.println(statement);
            System.out.println("de aici este: " + throwables.getMessage());
            //throwables.printStackTrace();
        }
        return result;
    }

    @NotNull
    public void assignStudentLaMaterie(Materii materie) {
        try {
            System.out.println("call asignareUserMaterie(" + curent.getIdUser() + ", " + materie.getIdMaterie() + ");");
            selectStatement.executeQuery("call asignareUserMaterie(" + curent.getIdUser() + ", " + materie.getIdMaterie() + ");");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            //throwables.printStackTrace();
        }
    }

    @NotNull
    public void renuntareLaMaterie(Materii materie) {
        try{
            selectStatement.executeUpdate("DELETE FROM users_materii WHERE id_user = " + curent.getIdUser() + " AND id_materie = " + materie.getIdMaterie() + ";" );
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            //throwables.printStackTrace();
        }
    }

    public void resetareOrar() {
        try{

            selectStatement.executeUpdate("DELETE FROM users_materii WHERE id_user = " + curent.getIdUser() + ";");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            //throwables.printStackTrace();
        }
    }

    @NotNull
    public boolean inregistrare(String email, String username, String parola, String nume, String prenume) {
        boolean result = false;
        try{
            String statement = new String("SELECT inregistrare('" + email + "', '" + username +"', '" + parola + "', '" + nume + "', '" + prenume + "');");
            rs = selectStatement.executeQuery(statement);
            rs.next();
            if (rs.getInt(1) == 0) {
                result = true;
            }
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            //throwables.printStackTrace();
        }
        return result;
    }

    public void setareNota(Materii materie, int nota) {
        try {
            selectStatement.executeUpdate("UPDATE users_materii SET nota = " + nota + " WHERE id_user = " + curent.getIdUser() + " AND id_materie = " + materie.getIdMaterie() + ";");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            //throwables.printStackTrace();
        }
    }

}
