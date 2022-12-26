package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeController {

    public void showRegister(ActionEvent event){
        try {
            System.out.printf("registruj se");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
            fxmlLoader.setController(new RegisterController());
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Hotel Registracija");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showExplore(ActionEvent event){
        try {
            System.out.printf("istrazi");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/explore.fxml"));
            fxmlLoader.setController(new ExploreController());
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Hotel Rooms");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
