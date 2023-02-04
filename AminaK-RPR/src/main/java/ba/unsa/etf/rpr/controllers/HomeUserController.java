package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeUserController {
    public Button btnEditProfile;
    public Button btnLogOut;
    public Label lblName;
    public Button btnMakeReservation;

    private User user;

    public HomeUserController() {
    }

    public HomeUserController(User u) {
        user = u;
    }

    public void initialize(){
        lblName.setText("Hello " + user.getName());
    }

    public void showEditWindow(ActionEvent actionEvent) {
        try{
            Stage stage = (Stage) btnEditProfile.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/edit.fxml"));
            fxmlLoader.setController(new EditProfileConstroller());
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void showHome(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnEditProfile.getScene().getWindow();
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

    public void showReservationWindow(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnMakeReservation.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/reserve.fxml"));
            fxmlLoader.setController(new ReservationController());
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
