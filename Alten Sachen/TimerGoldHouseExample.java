import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TimerGoldHouseExample extends Application {

    private volatile boolean running = true;
    private int seconds = 0;
    private int gold = 0;
    private int houses = 0;
    private int incomePerHouse = 2; // Basis-Einkommen pro Haus alle 10 Sekunden
    private Label timerLabel;
    private Label goldLabel;
    private Button buyHouseButton;

    @Override
    public void start(Stage primaryStage) {
        timerLabel = new Label("0 seconds");
        goldLabel = new Label("Gold: " + gold);
        buyHouseButton = new Button("Buy House (4 Gold)");

        // Thread für den Timer und das Gold-Einkommen durch das Haus
        Thread timerThread = new Thread(() -> {
            while (running) {
                try {
                    Thread.sleep(1000); // Warte 1 Sekunde
                    seconds++;
                    // Aktualisiere das Label auf dem JavaFX-Thread
                    Platform.runLater(() -> timerLabel.setText(seconds + " seconds"));

                    // Gib dem Benutzer alle 10 Sekunden das Gold-Einkommen pro Haus
                    if (seconds % 10 == 0) {
                    if (houses - 1 < 0){
                         gold = gold + 2;
                         Platform.runLater(() -> goldLabel.setText("Gold: " + gold));
                    } else {
                        int totalIncome = incomePerHouse * houses;
                        gold = gold + totalIncome;
                        Platform.runLater(() -> goldLabel.setText("Gold: " + gold));
                        
                      } // end of if-else
                     
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timerThread.setDaemon(true); // Setze den Thread als Daemon, damit er beendet wird, wenn das Hauptprogramm endet
        timerThread.start();

        // Event Handler für den Kauf des Hauses
        buyHouseButton.setOnAction(event -> {
            if (gold >= 4) {
                houses++;
                gold -= 4;
                incomePerHouse++;
                Platform.runLater(() -> {
                    goldLabel.setText("Gold: " + gold);
                    buyHouseButton.setText("Buy House (4 Gold) - Houses Owned: " + houses);
                });
            }
        });

        HBox root = new HBox();
        root.setPadding(new Insets(10));
        root.setSpacing(20);
        root.getChildren().addAll(timerLabel, goldLabel, buyHouseButton);

    Scene scene = new Scene(root, 268, 224);

        primaryStage.setTitle("Timer Gold House Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Beende den Timer-Thread, wenn die Anwendung geschlossen wird
        primaryStage.setOnCloseRequest(event -> running = false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

