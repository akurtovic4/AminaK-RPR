package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {

    public Button btnOkey;
    public Button btnLoginBack;

    public void showHomeUser(ActionEvent event){
        try {
            System.out.printf("homeuser");

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homeuser.fxml"));
            fxmlLoader.setController(new HomeUserController());
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("HomeUser");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void backToHome(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnLoginBack.getScene().getWindow();
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
