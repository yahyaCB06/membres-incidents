package com.example.demo.Service;

import com.example.demo.DB.GestionDB;
import com.example.demo.model.Incident;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncidentDaoImpl {
    GestionDB gestionDB = new GestionDB();
    public void inserer(Incident i){
        gestionDB.connecte("devoirblanc", "root", "");
        String req = "INSERT INTO incident(time, status) VALUES(?, ?)";
        try{
            PreparedStatement ps = gestionDB.connexion.prepareStatement(req);
            ps.setDate(1, i.getTime());
            ps.setString(2, i.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
