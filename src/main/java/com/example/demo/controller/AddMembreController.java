package com.example.demo.controller;

import com.example.demo.Dao.MembreDao;
import com.example.demo.Service.MemberDaoImpl;
import com.example.demo.model.Membre;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.UUID;

public class AddMembreController {
    @FXML
    private TextField email;

    @FXML
    private TextField nom;

    @FXML
    private TextField phone;

    @FXML
    private TextField prenom;

    @FXML
    void insererAction(MouseEvent event) {
        Membre membre = new Membre();
        MemberDaoImpl mdi = new MemberDaoImpl();
        membre.setIdentifiant(UUID.randomUUID().toString());
        membre.setNom(nom.getText());
        membre.setPrenom(prenom.getText());
        membre.setPhone(phone.getText());
        membre.setEmail(email.getText());
        mdi.inserer(membre);
    }
}
