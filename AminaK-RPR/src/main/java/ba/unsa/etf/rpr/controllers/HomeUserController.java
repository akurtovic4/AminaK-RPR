package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeUserController {
    public Button btnEditProfile;
    public Button btnLogOut;
    public Label lblName;
    public Button btnMakeReservation;
    public ListView listView;

    private User user;

    public HomeUserController() {
        user = new User();
    }

    public HomeUserController(User u) {
        user = u;
    }

    public void initialize() throws HotelException {

        lblName.setText("Hello " + user.getName());

        ObservableList items = FXCollections.observableArrayList();
        List<Reservation> reservationList = DaoFactory.reservationsDao().reservationsForUser(user.getId());
        items.addAll(reservationList);
        listView.setItems(items);
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
            fxmlLoader.setController(new MakeReservationController(user));
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
