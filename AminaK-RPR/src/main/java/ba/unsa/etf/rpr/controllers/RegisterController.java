package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * This controller handles window for registration
 */
public class RegisterController {

    /**
     * Attributes for RegisterController
     */
    public TextField nameFld;
    public TextField emailFld;
    public PasswordField passwordFld;
    public DatePicker datePickerID;
    public PasswordField confirmPasswordFld;
    public Button btnBack;
    public Button btnRegister2;
    private UserManager userManager = new UserManager();

    public GridPane registerGridPane;

    /**
     * This method adds user in database after user makes registration
     * @param event
     */
    public void userRegister(ActionEvent event) {
        try {
            User u = new User();
            u.setEmail(emailFld.getText());
            u.setName(nameFld.getText());
            u.setBirth_date(datePickerID.getValue());
            System.out.println(u.getBirth_date());
            u.setPassword(passwordFld.getText());
            userManager.add(u, confirmPasswordFld.getText());
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homeuser.fxml"));
            fxmlLoader.setController(new HomeUserController(u));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    /**
     * This method opens home window after user presses back button
     * @param actionEvent
     */
    public void goBackToHome(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) btnBack.getScene().getWindow();
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
