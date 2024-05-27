package tycoon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
 

public class TimerGoldHouseExample extends Application {

    private volatile boolean running = true;
    private int seconds = 0;
    private Label timerLabel;
    private Button Hauseins;
    @Override
    public void start(Stage primaryStage) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        timerLabel = new Label("0 seconds");
        Hauseins = new Button("Kaufe 1. Haus");
        // Thread f�r den Timer und das Gold-Einkommen durch das Haus
        Thread timerThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(1000); // Warte 1 Sekunde
                    seconds++;
                    // Aktualisiere das Label auf dem JavaFX-Thread
                    Platform.runLater(() -> timerLabel.setText(seconds + " seconds"));   
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.setDaemon(true); // Setze den Thread als Daemon, damit er beendet wird, wenn das Hauptprogramm endet
        timerThread.start();

        // Event Handler f�r den Kauf des Hauses
       
        
        Pane root = new Pane();
        root.setPadding(new Insets(10));
        root.getChildren().addAll(timerLabel, Hauseins);

        root.setId("pane");
        
    Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
    scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Timer Gold House Example");
        Image overlayImage1 = new Image("haus1.jpg");
        ImageView overlayH1 = new ImageView(overlayImage1);
        overlayH1.setVisible(false);
        primaryStage.setScene(scene);
        //screenbounds passt die Bildschirmgröße an
        primaryStage.setX(screenBounds.getMinX());
        primaryStage.setY(screenBounds.getMinY());
        primaryStage.setWidth(screenBounds.getWidth());
        primaryStage.setHeight(screenBounds.getHeight());
        primaryStage.show();
        

        // Beende den Timer-Thread, wenn die Anwendung geschlossen wird
        primaryStage.setOnCloseRequest(event -> running = false);
        Hauseins.setOnAction(event ->{
            Hotel h1 = new Hotel(1,1.5, 10, 100); 
            overlayH1.setVisible(true);
            DynArray H1dyn = new DynArray();
        });
    }

    public static void main(String[] args) {
        launch(args);
      
    }
}

