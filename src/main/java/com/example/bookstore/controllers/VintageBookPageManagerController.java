package com.example.bookstore.controllers;

import com.example.bookstore.Main;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.io.InputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import com.example.bookstore.model.Item;
import com.example.bookstore.model.ItemsList;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class VintageBookPageManagerController {

    @FXML
    private Button viewNewOrders;

    @FXML
    private Button SignOut;

    @FXML
    private Button goToHome;

    @FXML
    private Button edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9;

    @FXML
    private Button delete1,delete2,delete3,delete4,delete5,delete6,delete7,delete8,delete9;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;
    @FXML
    private ImageView image9;

    public VintageBookPageManagerController() {
    }

    public void goToHomePage(ActionEvent event) throws IOException {
        Main m= new Main();
        m.changeScene("home-page-manager.fxml");
    }

    public void goToNewOrdersPage(ActionEvent event) throws IOException {
        Main m= new Main();
        m.changeScene("new-orders-page.fxml");
    }

    public void goToSignPage(ActionEvent event) throws IOException {
        Main m= new Main();
        m.changeScene("login-page.fxml");
    }

    public void goToAddItemPage(ActionEvent event) throws IOException {
        Main m= new Main();
        m.changeScene("add-item-page.fxml");
    }

    public void deleteItem(){

    }

    public void editItem(){

    }/*
    private static VintageBookPageManagerController instance = null;

    public static VintageBookPageManagerController getInstance() {
        return instance;
    }*/

    public void initialize(){
        //instance = this;
        loadImages();
    }

    private int vintageNo=0;
    private void loadImages(){
        int l = ItemsList.getImages().size();
        for (int i = 0; i < l; i++)
            loadImage(ItemsList.getItems().get(i), ItemsList.getImages().get(i));
    }

    public void loadImage(Item item, Image img){
        if(item.getCategory().equals("vintage")) {
            vintageNo++;
            switch(vintageNo){
                case 1: image1.setImage(img);
                    break;
                case 2: image2.setImage(img);
                    break;
                case 3: image3.setImage(img);
                    break;
                case 4: image4.setImage(img);
                    break;
                case 5: image5.setImage(img);
                    break;
                case 6: image6.setImage(img);
                    break;
                case 7: image7.setImage(img);
                    break;
                case 8: image8.setImage(img);
                    break;
                case 9: image9.setImage(img);
                    break;
                default: throw new NullPointerException();
            }
        }
    }

}
