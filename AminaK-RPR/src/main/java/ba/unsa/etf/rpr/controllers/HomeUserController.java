package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This controller handles user homepage window
 */
public class HomeUserController {
    /**
     * Buttons, Label, ListView for HomeUserController
     */
    public Button btnEditProfile;
    public Button btnLogOut;
    public Label lblName;
    public Button btnMakeReservation;
    public ListView listView;
    public Button btnCancelReservation;
    private User user;
    private Reservation reservation;

    /**
     * Constructor for HomeUser controller that sets new User
     */
    public HomeUserController() {
        user = new User();
    }

    /**
     * Constructor for HomeUserController has User as parameter
     * @param u
     */
    public HomeUserController(User u) {
        user = u;
    }

    /**
     * Constructor for HomeUserController has Reservation as parameter
     * @param reservation
     */
    public HomeUserController(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Initialize method happens as soon as window is opened, contains listeners for list of reservations
     */
    public void initialize()  {

        lblName.setText("Hello " + user.getName());

        ObservableList items = FXCollections.observableArrayList();
        try{
            List<Reservation> reservationList = DaoFactory.reservationsDao().reservationsForUser(user.getId());
            if(!reservationList.isEmpty()){
                for(int i = 0; i < reservationList.size(); i++){
                    items.add(reservationList.get(i).getStart() + " " + reservationList.get(i).getEnd() + " " + reservationList.get(i).getId());
                }


                listView.setItems(items);
            }
        }catch (Exception e){
            e.printStackTrace();
        }





    }

    /**
     * Method for opening edit window
     * @param actionEvent
     */


    /**
     * Method for showing Home window after pressing back button
     * @param actionEvent
     */
    public void showHome(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnLogOut.getScene().getWindow();
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

    /**
     * Method that shows window for making reservations after pressing make reservation button
     * @param actionEvent
     */
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

    /**
     * Method that cancels reservation, moves it from listview and deletes it from database after pressing cancelReservation button
     * @param actionEvent
     */
    public void cancelReservation(ActionEvent actionEvent) {

      // btnCancelReservation.setOnAction(new EventHandler<ActionEvent>() {
      //      @Override public void handle(ActionEvent event) {
                 int selectedIdx = listView.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    Object itemToRemove = listView.getSelectionModel().getSelectedItem();

                   int newSelectedIdx =
                            (selectedIdx == listView.getItems().size() - 1)
                                    ? selectedIdx - 1
                                    : selectedIdx;

                    listView.getItems().remove(selectedIdx);

                    try {
                        DaoFactory.reservationsDao().reservationsForUser(user.getId()).remove(itemToRemove);
                        String [] index = itemToRemove.toString().split(" ");
                        int indexToDelete = Integer.parseInt(index[2]);
                        DaoFactory.reservationsDao().delete(indexToDelete);
                        System.out.println(itemToRemove);

                
                    } catch (HotelException e) {
                        throw new RuntimeException(e);
                    }
                    listView.refresh();
                    listView.getSelectionModel().select(newSelectedIdx);
                }
         //   }
    //    });

    }
}
