package project.client;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class StudentDashboard extends Application {

    private Label lblStudentId = new Label("--");
    private Label lblRanking = new Label("--");
    private Label lblCGPAValue = new Label("--");
    private Label lblTotalCredits = new Label("--");
    private Label lblCurrentSemester = new Label("--");


    public void start(Stage stage){
        VBox root = new VBox();
        //AnchorPane setup = new AnchorPane(root);

        //----------------------------header controls------------------------------
        //dashboard title
        Label lblTitle = new Label("Student Dashboard");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        lblTitle.setTextFill(Color.WHITE);

        //logout button
        Button btLogOut = new Button("Logout");
        btLogOut.setPrefSize(100,35);

        //top section
        HBox header = new HBox(900);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(10, 10, 15, 10));
        header.setStyle("-fx-background-color: #1c2d5a;");

        header.getChildren().addAll(lblTitle, btLogOut);

        //-------------------------user informations controls--------------------------
        //decoration rectangles
        HBox info = new HBox(10);
        info.setPadding(new Insets(10,10,5,10));
        info.getChildren().addAll(
                createInfoCard("Student ID", lblStudentId),
                createInfoCard("Ranking", lblRanking),
                createInfoCard("CGPA", lblCGPAValue),
                createInfoCard("Total Credits", lblTotalCredits),
                createInfoCard("Current Semester", lblCurrentSemester)
        );


        //--------------------------------Course result lists--------------------------
        GridPane courseList =  new GridPane();



        root.getChildren().addAll(header, info);
        stage.setScene(new Scene(root, 1260, 800));
        stage.show();

    }

    public VBox createInfoCard(String title, Label value){
        //TODO: Refaactor CSS into external css file
        //TODO: RMI

        //card title
        Label lblCardTitle = new Label(title);
        lblCardTitle.setStyle("-fx-text-fill: #6b7280;");

        //card value

        value.setStyle("-fx-font-size: 26px;" +
                " -fx-font-weight: bold;" +
                " -fx-text-fill: #3b5bdb;");

        VBox card = new VBox(20);
        card.getChildren().addAll(lblCardTitle, value);
        card.setPadding(new Insets(14, 20, 14, 20));

        card.setStyle("""
        -fx-background-color: white;
        -fx-background-radius: 15;
        -fx-pref-width: 300;
        -fx-pref-height: 100;
        -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.12), 10, 0, 0, 3);
        
        """);

        //HBox.setHgrow(card, Priority.ALWAYS);

        return card;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
