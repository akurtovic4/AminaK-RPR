package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RegisterController {

    private UserManager userManager = new UserManager();

    public GridPane registerGridPane;

    public TextField nameText;
    public TextField emailText;
    public PasswordField passwordText;
    public PasswordField confirmPasswordText;

    public void userRegister(ActionEvent event) {
        try {
            User u = new User();
            u.setEmail(emailText.getText());
            u.setName(nameText.getText());
            u.setBirth_date(LocalDate.of(1988,1,1));
            userManager.add(u);
            Stage s = (Stage)registerGridPane.getScene().getWindow();
            s.hide();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
