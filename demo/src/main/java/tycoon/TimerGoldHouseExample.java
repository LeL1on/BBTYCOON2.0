package tycoon;



import java.io.FileInputStream;
import java.io.InputStream;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
        InputStream stream = new FileInputStream("C:\\Users\\lakid\\Desktop\\PythPro\\BBTYCOON2.0\\demo\\src\\main\\java\\tycoon\\TestHaus.png");
        Image TestH1 = new Image(stream);
        ImageView overlayH1 = new ImageView(TestH1);
        
        System.out.println(TestH1.getWidth());
       
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
        root.getChildren().addAll(timerLabel, Hauseins, overlayH1);

        
        
    Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
    
        primaryStage.setTitle("Timer Gold House Example");
<<<<<<< HEAD
        
       // overlayH1.setVisible(false);
=======
        Image overlayImage1 = new Image("file:haus1.jpg");
        ImageView overlayH1 = new ImageView(overlayImage1);
        overlayH1.setVisible(false);
>>>>>>> 449a90ac6f14978b9edc565c5344617bdaea54f5
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
<<<<<<< HEAD
            //overlayH1.setVisible(true);

=======
            overlayH1.setVisible(true);
            overlayH1.setX(100);
            overlayH1.setY(100);
>>>>>>> 449a90ac6f14978b9edc565c5344617bdaea54f5
            DynArray H1dyn = new DynArray();
        });
    }

    public static void main(String[] args) {
        launch(args);
      
    }
}

