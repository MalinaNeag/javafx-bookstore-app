package com.example.bookstore.controllers;

import com.example.bookstore.Main;
import com.example.bookstore.exceptions.UsernameAlreadyExistsException;
import com.example.bookstore.model.CartItemsList;
import com.example.bookstore.model.DataHolderForCurrentUser;
import com.example.bookstore.model.User;
import com.example.bookstore.model.UsersList;
import com.example.bookstore.services.Register;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.json.JSONObject;

public class LoginController implements Initializable {
    public LoginController() {

    }

    @FXML
    private Button signIn;

    @FXML
    private Button register;

    @FXML
    private Label wrongLogin;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<String> role;

    private String[] roles={"customer","manager"};

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }
    @FXML
    private void checkLogin() throws IOException{

        if(username.getText().isEmpty() ) {
            wrongLogin.setText("Please fill in the username field");
        }
        else if(password.getText().isEmpty()) {
            wrongLogin.setText("Please fill in the password field");
        }
        else if(role.getValue()==null) {
            wrongLogin.setText("Please fill in the role field");
        }
        else if(UsersList.checkUserCredentials(new User(username.getText(),password.getText(),role.getValue(), null))) {
            Main m= new Main();
            if(role.getValue().equals("customer")) {
                DataHolderForCurrentUser.setCurrentUser(new User(username.getText(), password.getText(), role.getValue()));
                m.changeScene("home-page-customer.fxml");
            }
            else if(role.getValue().equals("manager")){
                m.changeScene("home-page-manager.fxml");
            }
        }
        else {
            wrongLogin.setText("User credentials are introduced wrong!");
        }


    }

    public void goToRegisterPage(ActionEvent event) throws IOException{
        Main m= new Main();
        m.changeScene("registration-page.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.getItems().addAll(roles);
    }


}
