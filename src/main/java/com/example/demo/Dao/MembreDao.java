package com.example.demo.Dao;

import com.example.demo.model.*;

import java.util.List;

public interface MembreDao {
    public void inserer(Membre m);
    public List<Incident> chargerListIncidents();
}
