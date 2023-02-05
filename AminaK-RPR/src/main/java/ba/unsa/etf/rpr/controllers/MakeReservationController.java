package ba.unsa.etf.rpr.controllers;

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

        radiobtnOne.selectedProperty().addListener((obs, stara, nova)->{
                if(nova != null) vrstaSobe = RoomType.SINGLE_ROOM.toString();
            });
        radiobtnTwo.selectedProperty().addListener((obs, stara, nova)->{
            if(nova != null) vrstaSobe = RoomType.SINGLE_ROOM.toString();
        });
        radiobtnThree.selectedProperty().addListener((obs, stara, nova)->{
            if(nova != null) vrstaSobe = RoomType.SINGLE_ROOM.toString();
        });
        radiobtnFour.selectedProperty().addListener((obs, stara, nova)->{
            if(nova != null) vrstaSobe = RoomType.SINGLE_ROOM.toString();
        });
        startDate = dpStart.getValue();
        endDate = dpEnd.getValue();
        System.out.println(vrstaSobe + " " + startDate + " " + endDate);

    }







    public void btnMakeReservation(ActionEvent actionEvent) {


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
