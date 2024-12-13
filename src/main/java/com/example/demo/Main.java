package com.example.demo;

import com.example.demo.Dao.MembreDao;
import com.example.demo.Service.MemberDaoImpl;
import com.example.demo.model.Membre;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/view/addMembre.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Member");
        primaryStage.show();

        MemberDaoImpl mdi = new MemberDaoImpl();
        String resourcePath = "C:/Users/one/IdeaProjects/demo/src/main/resources/com/example/demo/membersFile/membre.csv";
        Set<Membre> membres = mdi.chargerListeMembre(resourcePath);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
