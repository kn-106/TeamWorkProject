package com.kn106.js_raisers.firstAttempt;

import javafx.animation.*;
import javafx.application.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javafx.scene.shape.*;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


public class Graphics extends Application {
    public Desktop desktop = Desktop.getDesktop();

    public static void main(String[] args) {
        launch(args);
    }

    // Primary Stage



    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);

        // background
        Rectangle background = new Rectangle(0, 50,1920, 1080);
        background.setFill(Color.rgb(227,225,228));
        root.getChildren().add(background);

        // header
        Rectangle header = new Rectangle(0,0,1920, 50);
        header.setFill(Color.rgb(38,40,42));
        root.getChildren().add(header);

        // Settings
        Image setting_logo = new Image(new FileInputStream("pics/settings2.jpg"));
        ImageView setting_logoView = new ImageView(setting_logo);
        setting_logoView.setX(1860);
        setting_logoView.setY(10);
        root.getChildren().add(setting_logoView);

        // setting_logo onMouseIn
        setting_logoView.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // FAQ button cursor changer
                setting_logoView.setFitWidth(33);
                setting_logoView.setFitHeight(33);
                RotateTransition rt = new RotateTransition(Duration.millis(1000), setting_logoView);
                rt.setByAngle(360);
                rt.setCycleCount(1);
                rt.setAutoReverse(true);
                rt.play();

            }
        });

        // setting_logo onMouseOut
        setting_logoView.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                setting_logoView.setFitWidth(30);
                setting_logoView.setFitHeight(30);
            }
        });

        // setting_logo onMouseClicked
        setting_logoView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // popup menu for settings
                background.setFill(Color.rgb(98,98,98));

                Rectangle settings_popup_top = new Rectangle(310,100,1200, 15);
                settings_popup_top.setFill(Color.rgb(209,186,202));

                root.getChildren().add(settings_popup_top);

                // settings popup main field
                Rectangle settings_popup_main = new Rectangle(310,115,1200, 600);
                settings_popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(settings_popup_main);

                // settings popup borders
                Line settings_border1 = new Line(310,100,310,715);
                settings_border1.setStroke(Color.rgb(85,83,85));

                Line settings_border2 = new Line(1510,100,1510,715);
                settings_border2.setStroke(Color.rgb(85,83,85));

                Line settings_border3 = new Line(310,100,1510,100);
                settings_border3.setStroke(Color.rgb(85,83,85));

                Line settings_border4 = new Line(310,715,1510,715);
                settings_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(settings_border1, settings_border2, settings_border3, settings_border4);

                // settings Text
                Text text_inside_settings = new Text(800, 175, "Settings:");
                text_inside_settings.setFill(Color.rgb(53,56,58));
                text_inside_settings.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(text_inside_settings);

                CheckBox settings_check_box = new CheckBox();
                settings_check_box.setText("Use black/blue theme");
                //settings_check_box.setMaxWidth(15);
                settings_check_box.setLayoutX(400);
                settings_check_box.setLayoutY(250);
                settings_check_box.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 25));
                settings_check_box.setPadding(new Insets(7, 7, 7, 7));
                settings_check_box.setStyle(
                        "-fx-border-color: rgb(209,186,202); "
                                + "-fx-base: rgb(209,186,202);"
                                + "-fx-border-insets: -5;"
                                + "-fx-border-radius: 15;"
                                + "-fx-border-style: dotted;"
                                + "-fx-border-width: 2;"
                );




                root.getChildren().add(settings_check_box);
//                Text text2_inside_settings = new Text(350, 235, "Please read carefully these terms before using this application." +
//                        " By continuing using this application, you confirm that the terms are\nacceptable for you and you agree to be bound by them." +
//                        " If you do not agree to all of the terms set forth herein, please do not\nuse the application.");
//                text2_inside_settings.setFill(Color.rgb(53,56,58));
//                text2_inside_settings.setFont(Font.font ("Proxima Nova", 20));
//                root.getChildren().add(text2_inside_settings);

                // Settings ❌(close) button
                Text settings_close_but = new Text(1470, 145, "❌");
                settings_close_but.setFont(Font.font ("Verdana", 28));
                settings_close_but.setFill(Color.rgb(38,40,42));
                root.getChildren().add(settings_close_but);

                //Settings close button onMouseEntered
                settings_close_but.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                        // Settings button cursor changer
                        settings_close_but.setStyle("-fx-cursor: hand");
                        FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), settings_close_but);
                        fillTransition.setFromValue(Color.rgb(38,40,42));
                        fillTransition.setToValue(Color.rgb(214, 96, 148));
                        fillTransition.setAutoReverse(true);
                        fillTransition.play();

                    }
                });

                //Terms and Conditions close button onMouseExited
                settings_close_but.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        settings_close_but.setFill(Color.rgb(38,40,42));
                    }
                });

                // Terms and Conditions close button onMouseClicked
                settings_close_but.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        root.getChildren().removeAll( settings_check_box, settings_close_but, settings_border1, settings_border2, settings_border3, settings_border4, settings_popup_top, settings_popup_main, text_inside_settings);
                        background.setFill(Color.rgb(227,225,228));
                    }
                });
            }
        });



        // Logo
        Text logo = new Text(10, 35, "Java Project");
        logo.setFill(Color.WHITE);
        logo.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));
        root.getChildren().add(logo);

        // FAQ
        Text faq = new Text(1550, 32, "FAQ");
        faq.setFill(Color.WHITE);
        faq.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));
        root.getChildren().add(faq);

        // Terms & Conditions
        Text TC_text = new Text(1630, 32, "Terms & Conditions");
        TC_text.setFill(Color.WHITE);
        TC_text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 20));
        root.getChildren().add(TC_text);

        // Terms & Conditions events
        //Terms & Conditions onMouseEntered
        TC_text.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // Terms & Conditions button cursor changer
                TC_text.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), TC_text);
                fillTransition.setFromValue(Color.WHITE);
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //Terms & Conditions onMouseExited
        TC_text.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                TC_text.setFill(Color.WHITE);
            }
        });

        // Terms & Conditions onMouseClicked
        TC_text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                background.setFill(Color.rgb(98,98,98));
                // Terms & Conditions popup top field
                Rectangle popup_top = new Rectangle(310,100,1200, 15);
                popup_top.setFill(Color.rgb(209,186,202));

                root.getChildren().add(popup_top);

                // Terms & Conditions popup main field
                Rectangle popup_main = new Rectangle(310,115,1200, 600);
                popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(popup_main);

                // Terms & Conditions popup borders
                Line TC_border1 = new Line(310,100,310,715);
                TC_border1.setStroke(Color.rgb(85,83,85));

                Line TC_border2 = new Line(1510,100,1510,715);
                TC_border2.setStroke(Color.rgb(85,83,85));

                Line TC_border3 = new Line(310,100,1510,100);
                TC_border3.setStroke(Color.rgb(85,83,85));

                Line TC_border4 = new Line(310,715,1510,715);
                TC_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(TC_border1, TC_border2, TC_border3, TC_border4);

                // Terms & Conditions Text
                Text Text_inside_TC = new Text(700, 175, "Terms & Conditions:");
                Text_inside_TC.setFill(Color.rgb(53,56,58));
                Text_inside_TC.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(Text_inside_TC);

                Text Text2_inside_TC = new Text(350, 235, "Please read carefully these terms before using this application." +
                        " By continuing using this application, you confirm that the terms\nare acceptable for you and you agree to be bound by them." +
                        " If you do not agree to all of the terms set forth herein, please do not\nuse the application.");
                Text2_inside_TC.setFill(Color.rgb(53,56,58));
                Text2_inside_TC.setFont(Font.font ("Proxima Nova", 20));
                root.getChildren().add(Text2_inside_TC);

                // Terms and Conditions ❌(close) button
                Text TC_close_but = new Text(1470, 145, "❌");
                TC_close_but.setFont(Font.font ("Verdana", 28));
                TC_close_but.setFill(Color.rgb(38,40,42));
                root.getChildren().add(TC_close_but);

                //Terms and Conditions close button onMouseEntered
                TC_close_but.setOnMouseEntered(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {

                        // Terms and Conditions button cursor changer
                        TC_close_but.setStyle("-fx-cursor: hand");
                        FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), TC_close_but);
                        fillTransition.setFromValue(Color.rgb(38,40,42));
                        fillTransition.setToValue(Color.rgb(214, 96, 148));
                        fillTransition.setAutoReverse(true);
                        fillTransition.play();

                    }
                });

                //Terms and Conditions close button onMouseExited
                TC_close_but.setOnMouseExited(new EventHandler<MouseEvent>
                        () {

                    @Override
                    public void handle(MouseEvent t) {
                        TC_close_but.setFill(Color.rgb(38,40,42));
                    }
                });

                // Terms and Conditions close button onMouseClicked
                TC_close_but.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        root.getChildren().removeAll(TC_close_but, TC_border1, TC_border2, TC_border3, TC_border4, popup_top, popup_main, Text_inside_TC, Text2_inside_TC);
                        background.setFill(Color.rgb(227,225,228));
                    }
                });
            }
        });

////////////////////////////////////////////////////////////////////////////////////////////////////////
        // FAQ onMouseIn
        faq.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // FAQ button cursor changer
                faq.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), faq);
                fillTransition.setFromValue(Color.WHITE);
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        // FAQ onMouseOut
        faq.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                faq.setFill(Color.WHITE);
            }
        });

        // FAQ onMouseClicked
        faq.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                background.setFill(Color.rgb(98,98,98));
                ////////// FAQ popup field /////////////

                // FAQ popup top field
                Rectangle popup_top = new Rectangle(310,300,1200, 15);
                popup_top.setFill(Color.rgb(209,186,202));

                root.getChildren().add(popup_top);

                // FAQ popup main field
                Rectangle popup_main = new Rectangle(310,315,1200, 400);
                popup_main.setFill(Color.rgb(232,232,232));
                root.getChildren().add(popup_main);

                // FAQ popup borders
                Line popup_border1 = new Line(310,300,310,715);
                popup_border1.setStroke(Color.rgb(85,83,85));

                Line popup_border2 = new Line(1510,300,1510,715);
                popup_border2.setStroke(Color.rgb(85,83,85));

                Line popup_border3 = new Line(310,300,1510,300);
                popup_border3.setStroke(Color.rgb(85,83,85));

                Line popup_border4 = new Line(310,715,1510,715);
                popup_border4.setStroke(Color.rgb(85,83,85));

                root.getChildren().addAll(popup_border1, popup_border2, popup_border3, popup_border4);

                // Students who participated in this project
                Text inside_faq = new Text(500, 375, "Students who participated in this project:");
                inside_faq.setFill(Color.rgb(53,56,58));
                inside_faq.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                root.getChildren().add(inside_faq);

                // Students names
                Text inside_faq2 = new Text(780, 430, "Stadnytskyi Dmytro\nPotashnik Mykhailo\nMrglotskyi Markyian\nPashynina Alyona\nKazan Artur");
                inside_faq2.setFill(Color.rgb(115,108,120));
                inside_faq2.setFont(Font.font ("Proxima Nova", 30));
                root.getChildren().add(inside_faq2);

                // FAQ ❌(close) button
                Text FAQ_close_button = new Text(1470, 345, "❌");
                FAQ_close_button.setFont(Font.font ("Verdana", 28));
                FAQ_close_button.setFill(Color.rgb(38,40,42));
                root.getChildren().add(FAQ_close_button);

                        //FAQ close button onMouseEntered
                        FAQ_close_button.setOnMouseEntered(new EventHandler<MouseEvent>
                                () {

                            @Override
                            public void handle(MouseEvent t) {

                                // FAQ button cursor changer
                                FAQ_close_button.setStyle("-fx-cursor: hand");
                                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), FAQ_close_button);
                                fillTransition.setFromValue(Color.rgb(38,40,42));
                                fillTransition.setToValue(Color.rgb(214, 96, 148));
                                fillTransition.setAutoReverse(true);
                                fillTransition.play();

                            }
                        });

                        //FAQ close button onMouseExited
                        FAQ_close_button.setOnMouseExited(new EventHandler<MouseEvent>
                                () {

                            @Override
                            public void handle(MouseEvent t) {
                                FAQ_close_button.setFill(Color.rgb(38,40,42));
                            }
                        });

                        // FAQ_close_button onMouseClicked
                        FAQ_close_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                background.setFill(Color.rgb(227,225,228));
                                root.getChildren().removeAll(FAQ_close_button,inside_faq, inside_faq2, popup_border1, popup_border2, popup_border3, popup_border4, popup_top, popup_main);
                            }
                        });



            }
        });

        //work with image
        Text rgb_change_button = new Text(70, 150,"RGB changer");
        rgb_change_button.setFill(Color.rgb(53,56,58));
        rgb_change_button.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 40));
        root.getChildren().add(rgb_change_button);

        //// rgb_change_button events
        // rgb_change_button onMouseEntered
        rgb_change_button.setOnMouseEntered(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {

                // rgb_change_button button cursor changer
                rgb_change_button.setStyle("-fx-cursor: hand");
                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), rgb_change_button );
                fillTransition.setFromValue(Color.rgb(53,56,58));
                fillTransition.setToValue(Color.rgb(214, 96, 148));
                fillTransition.setAutoReverse(true);
                fillTransition.play();

            }
        });

        //rgb_change_button onMouseExited
        rgb_change_button.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent t) {
                rgb_change_button.setFill(Color.rgb(53,56,58));
            }
        });

        // rgb_change_button onMouseClicked
        rgb_change_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                final FileChooser fileChooser = new FileChooser();
                final File start_file = fileChooser.showOpenDialog(primaryStage);

                // Image to work with
                Image start_image = new Image(start_file.toURI().toString()); // to URI is full path
                ImageView start_imageView = new ImageView(start_image);

                start_imageView.setFitWidth(800);
                start_imageView.setFitHeight(450);
                start_imageView.setX(120);
                start_imageView.setY(300);

                root.getChildren().add(start_imageView);

                // Working with image
                WritableImage wImage = new WritableImage((int)start_image.getWidth(), (int)start_image.getHeight());
                PixelWriter pixelWriter = wImage.getPixelWriter();


                PixelReader pixelReader = start_image.getPixelReader();
                for(int i = 0; i < start_image.getWidth(); i++){
                    for(int j = 0; j < start_image.getHeight(); j++){
                        Color color = pixelReader.getColor(i, j);
                        pixelWriter.setColor(i, j, Color.color(color.getBlue(), color.getRed(), color.getGreen()));
                    }
                }

                // Try to save image to explorer

                    root.getChildren().remove(rgb_change_button);

                    try{
                        ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.png"));
                    Image finish_image = new Image(new FileInputStream("image.png"));
                    ImageView finish_imageView = new ImageView(finish_image);


                    Text old_pic_Text = new Text(470, 270,"Old");
                    old_pic_Text.setFill(Color.rgb(53,56,58));
                    old_pic_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));
                    root.getChildren().add(old_pic_Text);

                    Text new_pic_Text = new Text(1320, 270,"New");
                    new_pic_Text.setFill(Color.rgb(53,56,58));
                    new_pic_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));
                    root.getChildren().add(new_pic_Text);

                    finish_imageView.setFitWidth(800);
                    finish_imageView.setFitHeight(450);
                    finish_imageView.setX(970);
                    finish_imageView.setY(300);

                    root.getChildren().add(finish_imageView);

                    // Save jpg
                    Text save_jpg_Text = new Text(450, 850,"Save .jpg");
                    save_jpg_Text.setFill(Color.rgb(53,56,58));
                    save_jpg_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

                    root.getChildren().add(save_jpg_Text);

                    // Save png
                    Text save_png_Text = new Text(1330, 850,"Save .png");
                    save_png_Text.setFill(Color.rgb(53,56,58));
                    save_png_Text.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 30));

                    root.getChildren().add(save_png_Text);

                    // 🡐 Back button
                    Text back_button = new Text(60, 150,"\uD83E\uDC50 Back");
                    back_button.setFill(Color.rgb(53,56,58));
                    back_button.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 35));
                    root.getChildren().add(back_button);
                    // Back button listeners
                    //back_button button onMouseEntered
                    back_button.setOnMouseEntered(new EventHandler<MouseEvent>
                            () {

                        @Override
                        public void handle(MouseEvent t) {

                            // 🡐 Back button cursor changer
                            back_button.setStyle("-fx-cursor: hand");
                            FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), back_button);
                            fillTransition.setFromValue(Color.rgb(38,40,42));
                            fillTransition.setToValue(Color.rgb(214, 96, 148));
                            fillTransition.setAutoReverse(true);
                            fillTransition.play();

                        }
                    });

                    //back_button button onMouseExited
                    back_button.setOnMouseExited(new EventHandler<MouseEvent>
                            () {

                        @Override
                        public void handle(MouseEvent t) {
                            back_button.setFill(Color.rgb(38,40,42));
                        }
                    });

                    // back_button onMouseClicked
                    back_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                            root.getChildren().addAll(rgb_change_button);
                        }
                    });

                    //save_jpg_Text button onMouseEntered
                    save_jpg_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                            () {

                        @Override
                        public void handle(MouseEvent t) {

                            // save_jpg_Text button cursor changer
                            save_jpg_Text.setStyle("-fx-cursor: hand");
                            FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), save_jpg_Text);
                            fillTransition.setFromValue(Color.rgb(38,40,42));
                            fillTransition.setToValue(Color.rgb(214, 96, 148));
                            fillTransition.setAutoReverse(true);
                            fillTransition.play();

                        }
                    });

                    //save_jpg_Text button onMouseExited
                    save_jpg_Text.setOnMouseExited(new EventHandler<MouseEvent>
                            () {

                        @Override
                        public void handle(MouseEvent t) {
                            save_jpg_Text.setFill(Color.rgb(38,40,42));
                        }
                    });

                    // save_jpg_Text button onMouseClicked
                    save_jpg_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            try{
                            ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.jpg"));
                            root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            ////////// Successfully saved popup field /////////////

                            // Successfully saved popup top field
                            Rectangle success_popup_top = new Rectangle(310,300,1200, 15);
                            success_popup_top.setFill(Color.rgb(209,186,202));

                            root.getChildren().add(success_popup_top);

                            // Successfully saved popup main field
                            Rectangle success_popup_main = new Rectangle(310,315,1200, 400);
                            success_popup_main.setFill(Color.rgb(232,232,232));
                            root.getChildren().add(success_popup_main);

                            // Successfully saved popup borders
                            Line success_popup_border1 = new Line(310,300,310,715);
                            success_popup_border1.setStroke(Color.rgb(85,83,85));

                            Line success_popup_border2 = new Line(1510,300,1510,715);
                            success_popup_border2.setStroke(Color.rgb(85,83,85));

                            Line success_popup_border3 = new Line(310,300,1510,300);
                            success_popup_border3.setStroke(Color.rgb(85,83,85));

                            Line success_popup_border4 = new Line(310,715,1510,715);
                            success_popup_border4.setStroke(Color.rgb(85,83,85));

                            root.getChildren().addAll(success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4);

                            // Successfully saved text
                            background.setFill(Color.rgb(98,98,98));
                            Text inside_success_popup = new Text(700, 500, "Successfully saved");
                            inside_success_popup.setFill(Color.rgb(53,56,58));
                            inside_success_popup.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                            root.getChildren().add(inside_success_popup);

                            // success ❌(close) button
                            Text success_close_button = new Text(1470, 345, "❌");
                            success_close_button.setFont(Font.font ("Verdana", 28));
                            success_close_button.setFill(Color.rgb(38,40,42));
                            root.getChildren().add(success_close_button);

                            //success close button onMouseEntered
                            success_close_button.setOnMouseEntered(new EventHandler<MouseEvent>
                                    () {

                                @Override
                                public void handle(MouseEvent t) {

                                    // success_close_button cursor changer
                                    success_close_button.setStyle("-fx-cursor: hand");
                                    FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), success_close_button);
                                    fillTransition.setFromValue(Color.rgb(38,40,42));
                                    fillTransition.setToValue(Color.rgb(214, 96, 148));
                                    fillTransition.setAutoReverse(true);
                                    fillTransition.play();

                                }
                            });

                            //success_close_button onMouseExited
                            success_close_button.setOnMouseExited(new EventHandler<MouseEvent>
                                    () {

                                @Override
                                public void handle(MouseEvent t) {
                                    success_close_button.setFill(Color.rgb(38,40,42));
                                }
                            });

                            // success_close_button onMouseClicked
                            success_close_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    background.setFill(Color.rgb(227,225,228));
                                    root.getChildren().removeAll(success_close_button, inside_success_popup, success_popup_border1, success_popup_border2, success_popup_border3, success_popup_border4, success_popup_main, success_popup_top);
                                    root.getChildren().add(rgb_change_button);
                                }
                            });

                                }
                            });

                        ////////////////////////
                        save_png_Text.setOnMouseEntered(new EventHandler<MouseEvent>
                                () {

                            @Override
                            public void handle(MouseEvent t) {

                                // save_png_Text button cursor changer
                                save_png_Text.setStyle("-fx-cursor: hand");
                                FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), save_png_Text);
                                fillTransition.setFromValue(Color.rgb(38,40,42));
                                fillTransition.setToValue(Color.rgb(214, 96, 148));
                                fillTransition.setAutoReverse(true);
                                fillTransition.play();

                            }
                        });

                        //save_png_Text  button onMouseExited
                        save_png_Text.setOnMouseExited(new EventHandler<MouseEvent>
                                () {

                            @Override
                            public void handle(MouseEvent t) {
                                save_png_Text.setFill(Color.rgb(38,40,42));
                            }
                        });

                        // save_png_Text button onMouseClicked
                        save_png_Text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try {
                                    ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("image.png"));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                root.getChildren().removeAll(back_button, save_jpg_Text, save_png_Text, start_imageView, finish_imageView, new_pic_Text, old_pic_Text);

                                ////////// Successfully saved popup field /////////////

                                // Successfully saved popup top field
                                Rectangle success_popup_top2 = new Rectangle(310,300,1200, 15);
                                success_popup_top2.setFill(Color.rgb(209,186,202));

                                root.getChildren().add(success_popup_top2);

                                // Successfully saved popup main field
                                Rectangle success_popup_main2 = new Rectangle(310,315,1200, 400);
                                success_popup_main2.setFill(Color.rgb(232,232,232));
                                root.getChildren().add(success_popup_main2);

                                // Successfully saved popup borders
                                Line success_popup_border5 = new Line(310,300,310,715);
                                success_popup_border5.setStroke(Color.rgb(85,83,85));

                                Line success_popup_border6 = new Line(1510,300,1510,715);
                                success_popup_border6.setStroke(Color.rgb(85,83,85));

                                Line success_popup_border7 = new Line(310,300,1510,300);
                                success_popup_border7.setStroke(Color.rgb(85,83,85));

                                Line success_popup_border8 = new Line(310,715,1510,715);
                                success_popup_border8.setStroke(Color.rgb(85,83,85));

                                root.getChildren().addAll(success_popup_border5, success_popup_border6, success_popup_border7, success_popup_border8);

                                // Successfully saved text
                                background.setFill(Color.rgb(98,98,98));
                                Text inside_success_popup2 = new Text(750, 500, "Successfully saved");
                                inside_success_popup2.setFill(Color.rgb(53,56,58));
                                inside_success_popup2.setFont(Font.font ("Proxima Nova", FontWeight.BOLD, 45));
                                root.getChildren().add(inside_success_popup2);

                                // success ❌(close) button
                                Text success_close_button2 = new Text(1470, 345, "❌");
                                success_close_button2.setFont(Font.font ("Verdana", 28));
                                success_close_button2.setFill(Color.rgb(38,40,42));
                                root.getChildren().add(success_close_button2);

                                //success_close_button onMouseExited
                                success_close_button2.setOnMouseExited(new EventHandler<MouseEvent>
                                        () {

                                    @Override
                                    public void handle(MouseEvent t) {
                                        success_close_button2.setFill(Color.rgb(38,40,42));
                                    }
                                });

                                // success_close_button onMouseClicked
                                success_close_button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    @Override
                                    public void handle(MouseEvent event) {
                                        background.setFill(Color.rgb(227,225,228));
                                        root.getChildren().removeAll(success_close_button2, inside_success_popup2, success_popup_border5, success_popup_border6, success_popup_border7, success_popup_border8, success_popup_main2, success_popup_top2);
                                        root.getChildren().add(rgb_change_button);
                                    }
                                });

                                //success close button onMouseEntered
                                success_close_button2.setOnMouseEntered(new EventHandler<MouseEvent>
                                        () {

                                    @Override
                                    public void handle(MouseEvent t) {

                                        // success_close_button cursor changer
                                        success_close_button2.setStyle("-fx-cursor: hand");
                                        FillTransition fillTransition = new FillTransition(Duration.seconds(0.3), success_close_button2);
                                        fillTransition.setFromValue(Color.rgb(38,40,42));
                                        fillTransition.setToValue(Color.rgb(214, 96, 148));
                                        fillTransition.setAutoReverse(true);
                                        fillTransition.play();

                                    }
                                });

                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }

                      /////////////// Mb for future //////////////////////////
                    //try {                                          @@@   With this try
                    //desktop.open(file);                            @@@   catch thing we can
//                    } catch (IOException ex) {                     @@@   open image directly from
//                        Logger.getLogger(                          @@@   explorer with appointed
//                                Graphics.class.getName()).log(     @@@   file type opener
//                                Level.SEVERE, null, ex             @@@   !Don't delete please
//                        );
//                    }
                      ////////////////////////////////////////////////////////



            }
        });

        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("file:pics/agreement.png"));
        primaryStage.setTitle("KN-106 Teamwork Project");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
