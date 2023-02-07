package ba.unsa.etf.rpr.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This is controller that handles home window where user can log in, register
 */
public class HomeController {


    public Button btnExplore;
    public Button btnRegister;
    public Button btnLogin;

    /**
     * This method shows registration form once the user presses the Make a reservation button
     * @param event
     */
    public void showRegister(ActionEvent event){
        try {

            Stage scenica = (Stage) btnExplore.getScene().getWindow();
            scenica.close();
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

    /**
     * This method shows Explore window once user presses Explore button
     * @param event
     */
    public void showExplore(ActionEvent event){
        try {
            System.out.printf("istrazi");
            Stage pozornica = (Stage) btnExplore.getScene().getWindow();
            pozornica.close();
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



    public void showLogin(ActionEvent event){
        try {
            System.out.printf("login");
            Stage pozornica1 = (Stage) btnLogin.getScene().getWindow();
            pozornica1.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            fxmlLoader.setController(new LoginController());
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Log in");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
