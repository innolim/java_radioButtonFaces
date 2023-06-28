package radiobuttonfaces;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Sunlim Lee
 * COP2805/ Homework #3
 * 2/6/2023
 * This GUI program lets the user select on of two faces by providing radio button
 * selections. When a radio button is clicked, its corresponding face is displayed
 */
public class RadioButtonFaces extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a BorderPane
        BorderPane pane = new BorderPane();
        // Create a hBox
        HBox hBox = new HBox(40); 
        hBox.setPadding(new Insets(5,5,5,5));
        hBox.setAlignment(Pos.CENTER); // Set hBox in the center
        
         // Create radio button
        RadioButton rb1 = new RadioButton("Smiley face"); // Button for smiley face
        rb1.setContentDisplay(ContentDisplay.LEFT); // Set button on the left
        rb1.setSelected(false); // Initially set as unselected
        rb1.setPadding(new Insets(5,5,5,5));
        RadioButton rb2 = new RadioButton("Sad face");// Button for sad face
        rb2.setContentDisplay(ContentDisplay.LEFT);
        rb2.setSelected(false); // Initially set as unselected
        rb2.setPadding(new Insets(5,5,5,5));
        hBox.getChildren().addAll(rb1, rb2); // Add both buttons in the hBox
        // Create ToggleGroup. Buttons wil work simultaneously not individually
        ToggleGroup group = new ToggleGroup(); 
        rb1.setToggleGroup(group); // Put button 1 in the group
        rb2.setToggleGroup(group); // put button 2 in the group
        
        pane.setBottom(hBox); // Put the hBox on the bottom of the pane
        
        StackPane stackPane = new StackPane(); // Create a StackPane object
       /* 
        Register an event handler that handles the action event uopn button 
        selection-> When a radio button is selected, the corresponding face is
        displayed
        */
        rb1.setOnAction(e-> {
        // Draw the face as a circle
        Circle c1 = new Circle(30, 30, 60);// Create a Circle object c1
        c1.setStroke(Color.BLACK); // Set a line drawing attribute
        c1.setFill(Color.WHITE); // Set the fill color
        stackPane.getChildren().add(c1); // Add c1 to HBox
        
        // Draw the left eye as an ellipse
        Ellipse o1 = new Ellipse(15, 15, 5, 10); // Create Ellipse object o1
        o1.setStroke(Color.BLACK);
        o1.setFill(Color.WHITE);
        
        // Draw the right eye as another ellipse
        Ellipse o2 = new Ellipse(50, 15, 5, 10); // Create Ellipse object o2
        o2.setStroke(Color.BLACK);
        o2.setFill(Color.WHITE);
        
        // Draw a smiley mouth as an open arc
        Arc arc1 = new Arc(30, 30, 40, 30, 240, 65); // Create an arc1
        arc1.setStroke(Color.BLACK); // Set line-drawing attribute
        arc1.setFill(Color.WHITE); // Set fill color
        arc1.setType(ArcType.OPEN); // Set arc type
        
         // group all the smiley face features, including the text, the face, two eyes and the smiley mouth
        Group group1 = new Group();// Create a Group object group1
        group1.getChildren().addAll(c1, o1, o2, arc1);
        stackPane.getChildren().add(new Group(group1));
            // If button 1 is selected, smile face appears
            if(rb1.isSelected()){
                stackPane.getChildren().add(group1);
            }
        });
        // Action Event upon selecting button 2 for sad face
        rb2.setOnAction(e-> {
        Circle c2 = new Circle(30, 30, 60);// Create a Circle object c1
        c2.setStroke(Color.BLACK); // Set a line drawing attribute
        c2.setFill(Color.WHITE); // Set the fill color
        stackPane.getChildren().add(c2); // Add c1 to HBox
        
        // Draw the left eye as an ellipse
        Ellipse o3 = new Ellipse(15, 15, 5, 10); // Create Ellipse object o1
        o3.setStroke(Color.BLACK);
        o3.setFill(Color.WHITE);
        
        // Draw the right eye as another ellipse
        Ellipse o4 = new Ellipse(50, 15, 5, 10); // Create Ellipse object o2
        o4.setStroke(Color.BLACK);
        o4.setFill(Color.WHITE);
        
        // Draw a smiley mouth as an open arc
        Arc arc2 = new Arc(30, 60, 20, 10, 0, 180); // Create an arc1
        arc2.setStroke(Color.BLACK); // Set line-drawing attribute
        arc2.setFill(Color.WHITE); // Set fill color
        arc2.setType(ArcType.OPEN); // Set arc type
    
         // group all the smiley face features, including the text, the face, two eyes and the smiley mouth
       Group group2 = new Group(); // Create a Group object group2
        group2.getChildren().addAll(c2, o3, o4, arc2);
        stackPane.getChildren().add(new Group(group2));
            // If button 2 is selected, sad face appears
            if(rb2.isSelected()){
                stackPane.getChildren().add(group2);
            }
        });
      
        pane.setCenter(stackPane);
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Homework 3_2"); // Set the title of stage
        primaryStage.setScene(scene); // Set scene in the stage
        primaryStage.show(); // Display the stage
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
