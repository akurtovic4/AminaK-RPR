package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {

    public Button btnOkey;
    public TextField emailFld;
    public PasswordField passwordFld;
    User u = new User();
    public Button btnLoginBack;

    public void showHomeUser(ActionEvent event){
        try {
            System.out.printf("homeuser");
            Stage stage1 = (Stage) btnLoginBack.getScene().getWindow();
            stage1.close();
            u.setPassword(passwordFld.getText());
            u.setEmail(emailFld.getText());
            u = DaoFactory.usersDao().getByEmail(u.getEmail());
            (new UserManager()).login(u.getEmail(), u.getPassword());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/homeuser.fxml"));
            fxmlLoader.setController(new HomeUserController(u));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("HomeUser");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setResizable(false);
            stage.show();

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

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
