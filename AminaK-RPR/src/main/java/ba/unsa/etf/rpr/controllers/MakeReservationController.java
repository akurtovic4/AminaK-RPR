package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ReservationManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.bytebuddy.asm.Advice;


import java.time.LocalDate;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MakeReservationController {
    public DatePicker dpStart;
    public ListView reservationList;
    public Button btnReserve;
    public Button btnGoBackUser;
    public RadioButton radiobtnOne;
    public ToggleGroup toggleGroup;
    public RadioButton radiobtnTwo;
    public RadioButton radiobtnThree;
    public RadioButton radiobtnFour;
    public DatePicker dpEnd;

    private String vrstaSobe;
    private LocalDate startDate;
    private LocalDate endDate;


    @FXML
    public void initialize() {

            vrstaSobe=RoomType.SINGLE_ROOM.toString();
            radiobtnOne.selectedProperty().addListener((obs, stara, nova)->{
                if(nova!=false) {
                    vrstaSobe = RoomType.SINGLE_ROOM.toString();

                }
            });
            radiobtnTwo.selectedProperty().addListener((obs, stara, nova)->{
                if(nova!=false) {
                    vrstaSobe = RoomType.DOUBLE_ROOM.toString();

                }
            });
            radiobtnThree.selectedProperty().addListener((obs, stara, nova)->{
                if(nova != false) vrstaSobe = RoomType.TRIPLE_ROOM.toString();
            });
            radiobtnFour.selectedProperty().addListener((obs, stara, nova)->{
                if(nova != false) vrstaSobe = RoomType.QUADRUPLE_ROOM.toString();
            });

            dpStart.valueProperty().addListener((obs, stara, nova)->{
                startDate=dpStart.getValue();
                System.out.println(startDate);

            });

            dpEnd.valueProperty().addListener((obs, stara, nova)->{
                endDate=dpEnd.getValue();
                System.out.println(endDate);
            });







    }







    public void btnMakeReservation(ActionEvent actionEvent) {
        try {
            (new ReservationManager()).isTimeValid(startDate,endDate);
            System.out.println(startDate);
            System.out.println("vrsta sobe: " + vrstaSobe + " start date: " + startDate + " end date: "+ endDate);
        } catch (HotelException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    public void goBackToHome(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnReserve.getScene().getWindow();
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
