package com.example.demo.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionDB {
    public Connection connexion;

    public void connecte(String bd, String user, String pass) {
        String url= "jdbc:mysql://localhost:3306/"+bd;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void close(){
        try {
            if (connexion != null) connexion.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
