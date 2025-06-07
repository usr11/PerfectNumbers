import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ClientGUI extends Application {

    private TextField txtStart;
    private TextField txtEnd;
    private TextField txtWorkers;
    private TextArea txtResults;
    private Label lblTime;

    @Override
    public void start(Stage primaryStage) {
        txtStart = new TextField();
        txtEnd = new TextField();
        txtWorkers = new TextField();
        txtWorkers.setPromptText("Optional");

        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setWrapText(true);
        txtResults.setPrefHeight(250);

        lblTime = new Label("Execution time: -");

        Button btnSearch = new Button("Find Perfect Numbers");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(15));

        grid.add(new Label("Start of range:"), 0, 0);
        grid.add(txtStart, 1, 0);

        grid.add(new Label("End of range:"), 0, 1);
        grid.add(txtEnd, 1, 1);

        grid.add(new Label("Number of workers:"), 0, 2);
        grid.add(txtWorkers, 1, 2);

        grid.add(btnSearch, 0, 3, 2, 1);
        grid.add(new Label("Results:"), 0, 4);
        grid.add(txtResults, 0, 5, 2, 1);
        grid.add(lblTime, 0, 6, 2, 1);

        // Button action
        btnSearch.setOnAction(e -> handleSearch());

        Scene scene = new Scene(grid, 500, 450);
        primaryStage.setTitle("Perfect Numbers Client (ICE)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void handleSearch() {
        int start, end, workers = -1;

        try {
            start = Integer.parseInt(txtStart.getText());
            end = Integer.parseInt(txtEnd.getText());
        } catch (NumberFormatException e) {
            txtResults.setText("Please enter valid numbers for start and end.");
            return;
        }

        String workersText = txtWorkers.getText();
        if (!workersText.isEmpty()) {
            try {
                workers = Integer.parseInt(workersText);
                if (workers < 1 || workers > 20) {
                    txtResults.setText("Number of workers must be between 1 and 20.");
                    return;
                }
            } catch (NumberFormatException e) {
                txtResults.setText("Please enter a valid number of workers.");
                return;
            }
        }

        long startTime = System.currentTimeMillis();

        String result;
        if (workers == -1) {
            result = Client.findPerfectNumbers(start, end);
        } else {
            result = Client.findPerfectNumbers(start, end, workers);
        }

        long elapsed = System.currentTimeMillis() - startTime;

        txtResults.setText(result);
        lblTime.setText("Execution time: " + elapsed + " ms");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
