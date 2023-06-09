package com.example.bookstore.controllers;

import com.example.bookstore.Main;
import com.example.bookstore.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class CartPageController {
    @FXML
    private Button SignOut;

    @FXML
    private Button goToHome;

    @FXML
    private Button clearCartButton;

    @FXML
    private Button Checkout;

    @FXML
    private Button viewPreviousOrdersButton;

    @FXML
    private Button total;
    @FXML
    private Label ItemId1,ItemId2,ItemId3,ItemId4,ItemId5;

    @FXML
    private Label ItemAuthor1,ItemAuthor2,ItemAuthor3,ItemAuthor4,ItemAuthor5;
    @FXML
    private Label ItemDetail1,ItemDetail2,ItemDetail3,ItemDetail4,ItemDetail5;
    @FXML
    private Label totalPrice;
    @FXML
    private Label CheckoutMessage;

    private int totalsum;

    StringBuilder orderDetails;


    public void goToSignPage(ActionEvent event) throws IOException {
        CartItemsList.removeAllItems();
        Main m= new Main();
        m.changeScene("login-page.fxml");
    }

    public void goToPreviousOrdersPage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("previous-orders-page.fxml");
    }

    public void goToHomePage(ActionEvent event) throws IOException {
        Main m= new Main();
        m.changeScene("home-page-customer.fxml");
    }

    public void initialize(){
        orderDetails= new StringBuilder();
        for(int i=0;i< CartItemsList.getItems().size();i++){
            orderDetails.append(CartItemsList.getIdOfItem(i)).append(", ");

            if(i==0) {
                ItemId1.setText(CartItemsList.getIdOfItem(0));
                ItemDetail1.setText(CartItemsList.getDetails1(0));
                ItemAuthor1.setText(CartItemsList.getAuthor(0));
                totalsum=totalsum+CartItemsList.getPriceItems(0);

            }
            else if(i==1){
                ItemId2.setText(CartItemsList.getIdOfItem(1));
                ItemDetail2.setText(CartItemsList.getDetails1(1));
                ItemAuthor2.setText(CartItemsList.getAuthor(1));
                totalsum=totalsum+CartItemsList.getPriceItems(1);

            }
            else if(i==2){
                ItemId3.setText(CartItemsList.getIdOfItem(2));
                ItemDetail3.setText(CartItemsList.getDetails1(2));
                ItemAuthor3.setText(CartItemsList.getAuthor(2));
                totalsum=totalsum+CartItemsList.getPriceItems(2);

            }
            else if(i==3){
                ItemId4.setText(CartItemsList.getIdOfItem(3));
                ItemDetail4.setText(CartItemsList.getDetails1(3));
                ItemAuthor4.setText(CartItemsList.getAuthor(3));
                totalsum=totalsum+CartItemsList.getPriceItems(3);
            }
            else if(i==4){
                ItemId5.setText(CartItemsList.getIdOfItem(4));
                ItemDetail5.setText(CartItemsList.getDetails1(4));
                ItemAuthor5.setText(CartItemsList.getAuthor(4));
                totalsum=totalsum+CartItemsList.getPriceItems(4);

            }
        }
        totalPrice.setText(""+totalsum+" RON");
    }
    public void clearCart(ActionEvent event) throws IOException {
        CartItemsList.clear();
        goToCartPage(event);

    }
    public void goToCartPage(ActionEvent event) throws IOException {
        Main m= new Main();
        m.changeScene("cart-page.fxml");
    }
    public void Checkout(ActionEvent event) throws IOException {
        if (totalsum != 0) {
            User currentUser = null;
            for (int i = 0; i < UsersList.getUsers().size(); i++) {
                if (DataHolderForCurrentUser.getCurrentUser().equals(UsersList.getUsers().get(i)))
                    currentUser = UsersList.getUsers().get(i);
            }

            String userName = currentUser.getUsername();
            int orderNumber = currentUser.getOrders().size();
            String orderId = orderNumber + userName;

            currentUser.getOrders().add(new Order(orderId, orderDetails.toString(), "unprocessed"));

            UsersList.persistUsers();

            Main m = new Main();
            m.changeScene("place-orders-page.fxml");
        } else {
            CheckoutMessage.setVisible(true);
            CheckoutMessage.setText("Your order has NOT been placed!");
        }
    }


}
