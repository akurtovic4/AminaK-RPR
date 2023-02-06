package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
/**
 * This is controller that handles explore window where user can see pictures od hotel rooms
 */
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class ExploreController {

    public Button btnBackToHomepage;

    /**
     *
     * @param event
     * Method that shows register window when user presses Register button
     */
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

    /**
     *
     * @param actionEvent
     * This method shows Hotel home page when user presses back button
     */
    public void showHomePage(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnBackToHomepage.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            fxmlLoader.setController(new HomeController());
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));

            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
}
