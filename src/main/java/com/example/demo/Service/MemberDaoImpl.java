package com.example.demo.Service;

import com.example.demo.DB.GestionDB;
import com.example.demo.model.Incident;
import com.example.demo.model.Membre;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberDaoImpl {
    GestionDB gestionDB = new GestionDB();

    public void inserer(Membre membre){
        gestionDB.connecte("devoirblanc", "root", "");
        String req = "insert into membre(identifiant,nom, prenom, email, phone) values(?,?,?,?,?)";
        try{
            PreparedStatement ps = gestionDB.connexion.prepareStatement(req);
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, membre.getNom());
            ps.setString(3, membre.getPrenom());
            ps.setString(4, membre.getEmail());
            ps.setString(5, membre.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Incident> chargerListIncidents(int id){
        gestionDB.connecte("devoirlibre", "root", "");
        String req = "SELECT * FROM incident where idMembre="+id;
        List<Incident> incidents = new ArrayList<>();
        try {
            PreparedStatement ps = gestionDB.connexion.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int reference = rs.getInt("idIncident");
                Date time = rs.getDate("time");
                String status = rs.getString("status");
                Incident incident = new Incident(reference, time, status);
                incidents.add(incident);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return incidents;
    }


    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            br.readLine();
            while ((ligne = br.readLine()) != null) {
                String[] record = ligne.split(",");
                if (record.length == 4) {
                    String nom = record[0].trim();
                    String prenom = record[1].trim();
                    String email = record[2].trim();
                    String phone = record[3].trim();
                    String identifiant = UUID.randomUUID().toString();
                    Membre membre = new Membre(identifiant, nom, prenom, email, phone);
                    membres.add(membre); // Ajout du membre dans le Set
                }
            }

            // Affichage après avoir lu tout le fichier
            System.out.println("Liste finale des membres :");
            for (Membre m : membres) {
                System.out.println(m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return membres;
    }


}
