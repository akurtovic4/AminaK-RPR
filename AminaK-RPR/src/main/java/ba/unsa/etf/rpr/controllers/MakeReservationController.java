package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ReservationManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.Room;
import ba.unsa.etf.rpr.domain.RoomType;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HotelException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.bytebuddy.asm.Advice;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
    public Label labelForPrice;

    private String vrstaSobe;
    private LocalDate startDate;
    private LocalDate endDate;

    private ReservationManager reservationManager = new ReservationManager();

    private User user;

    public MakeReservationController(User user) {
        this.user = user;
    }


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

                long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);
                int numberOfDays1 = (int)numberOfDays;

                if(vrstaSobe == "SINGLE_ROOM")
                    labelForPrice.setText("" + numberOfDays1 * 5 + "$");

                if(vrstaSobe == "DOUBLE_ROOM")
                    labelForPrice.setText("" + numberOfDays1 * 10 + "$");

                if(vrstaSobe == "TRIPLE_ROOM")
                    labelForPrice.setText("" + numberOfDays1 * 15 + "$");

                if(vrstaSobe == "QUADRUPLE_ROOM")
                    labelForPrice.setText("" + numberOfDays1 * 20 + "$");
            });




    }







    public void btnMakeReservation(ActionEvent actionEvent) {
        try {
            (new ReservationManager()).isTimeValid(startDate,endDate);
            List<Room> listOfAllRoomsThatCanWork =  DaoFactory.roomsDao().allRoomsThatCanWork(vrstaSobe);
            List<Room> listOfTakenRooms = DaoFactory.reservationsDao().reservedRooms(startDate,endDate);
            for(int i = 0; i < listOfAllRoomsThatCanWork.size(); i++){
               if(!listOfTakenRooms.contains(listOfAllRoomsThatCanWork.get(i))){
                   Reservation reservation = new Reservation();
                   reservation.setId(1);
                   reservation.setUser(user);
                   reservation.setStart(startDate);
                   reservation.setEnd(endDate);
                   reservation.setComments("");
                   reservation.setRoom(listOfAllRoomsThatCanWork.get(i));

                   reservationManager.add(reservation);

                }



            }


        } catch (HotelException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }



    public void goBackToHome(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnReserve.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homeuser.fxml"));
            fxmlLoader.setController(new HomeUserController(user));
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
