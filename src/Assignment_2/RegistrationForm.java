/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_2;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class RegistrationForm extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox v = new VBox (5);
        v.setPadding(new Insets(20));
        
        GridPane gp = new GridPane();
        gp.setPadding(new Insets (10,10,10,10));
        gp.setHgap(20);
        gp.setVgap(20);
        
        Label L1 = new Label ("Name :");
        gp.add(L1, 1, 1);
        TextField T1 = new TextField();
        T1.setPrefColumnCount(20);
        gp.add(T1, 2, 1);
        Label L2 = new Label ("Email :");
        gp.add(L2, 1, 2);
        TextField T2 = new TextField ();
        T2.setPrefColumnCount(20);
        gp.add(T2, 2, 2);
        Label L3 = new Label ("Phone :");
        gp.add(L3, 1,3);
        TextField T3 = new TextField();
             T3.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            T3.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
});
             gp.add(T3, 2, 3);
             
        Label L4 = new Label ("Password :");
        gp.add(L4, 1, 4);
        PasswordField P1 = new PasswordField();
        P1.setPrefColumnCount(20);
        gp.add(P1, 2, 4);
        
        Label L5 = new Label ("Comfirm :");
        gp.add(L5, 1, 5);
        PasswordField P2 = new PasswordField();
        P2.setPrefColumnCount(20);
        gp.add(P2, 2, 5);
        
        
        Label L6 = new Label ("Country :");
        gp.add(L6, 1, 6);
        ComboBox cb = new ComboBox ();
        cb.getItems().addAll("USA","French","Germany");
        cb.setPromptText("Select...");
        gp.add(cb, 2, 6);
        HBox H1 = new HBox (20);    
        Label L7 = new Label("Genre");
        gp.add(L7, 1, 7);
        ToggleGroup group = new ToggleGroup();
        RadioButton rb = new RadioButton("Male");
        rb.setToggleGroup(group);
        RadioButton rb1 = new RadioButton("Female");
        rb1.setToggleGroup(group);
        H1.getChildren().addAll(rb,rb1);
        gp.add(H1, 2,7);
        Label L8 = new Label("Language");
        gp.add(L8, 1, 8);
        HBox H2 = new HBox (20);
        CheckBox box1 = new CheckBox("Arabic");
        CheckBox box2 = new CheckBox("English");
        CheckBox box3 = new CheckBox("French");
        H2.getChildren().addAll(box1,box2,box3);
        gp.add(H2, 2, 8);
        Label L9 = new Label("About You:");
        gp.add(L9, 1, 9);
        TextArea Ta = new TextArea();
        Ta.setPrefColumnCount(20);
        Ta.setPrefRowCount(5);
        gp.add(Ta, 2, 9);
        HBox h2 = new HBox ();
        h2.setPadding(new Insets (25));
        Button btn = new Button("Register");
        btn.setPrefWidth(350);
        Label L10 = new Label ("Invalid Email \n Incorrect Password");
        L10.setTextFill(Color.RED);
        
        
        h2.getChildren().add(btn);
        v.getChildren().addAll(gp,h2,L10);
        Scene scene = new Scene (v,500,500);
        primaryStage.setTitle("Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
