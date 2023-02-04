package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class EditProfileConstroller {
    public Button btnSaveChanges;
    public Button btnGoUserHome;

    public void saveChanges(ActionEvent actionEvent) {
    }

    public void goUserHome(ActionEvent actionEvent) {
        try{
            Stage stage = (Stage) btnGoUserHome.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homeuser.fxml"));
            fxmlLoader.setController(new HomeUserController());
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
