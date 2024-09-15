
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class festivalGUI extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) {
        //Create title bar
        HBox titleBar = createTitleBar(primaryStage);

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(newItem, openItem, saveItem, exitItem);

        // Create Edit menu
        Menu editMenu = new Menu("Edit");
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);

        // Add menus to menu bar
        menuBar.getMenus().addAll(fileMenu, editMenu);
        menuBar.setStyle("-fx-background-color: transparent;");

        // Add action handlers
        newItem.setOnAction(e -> System.out.println("New file"));
        openItem.setOnAction(e -> System.out.println("Open file"));
        saveItem.setOnAction(e -> System.out.println("Save file"));
        exitItem.setOnAction(e -> System.exit(0));

        cutItem.setOnAction(e -> System.out.println("Cut"));
        copyItem.setOnAction(e -> System.out.println("Copy"));
        pasteItem.setOnAction(e -> System.out.println("Paste"));

        // Create 5 transparent buttons
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        for (int i = 1; i <= 5; i++) {
            Button button = new Button("Button " + i);
            button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: black;" +
                "-fx-border-width: 1px;" +
                "-fx-text-fill: black;"
            );
            
            // Add hover effect
            button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: rgba(0,0,0,0.1); -fx-border-color: black; -fx-border-width: 1px; -fx-text-fill: black;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 1px; -fx-text-fill: black;"));

            // Add click action
            button.setOnAction(e -> System.out.println(button.getText() + " clicked"));

            buttonBox.getChildren().add(button);
        }

        VBox vBox = new VBox(titleBar, menuBar, buttonBox);
        //vBox.getChildren().addAll(menuBar, buttonBox);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setStyle("-fx-background-color: orange;");//-fx-padding: 10;

        Scene scene = new Scene(vBox, 300, 600);

        // Set the stage style to TRANSPARENT
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        // Make the window draggable
        /*vBox.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        vBox.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });*/

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createTitleBar(Stage primaryStage) {
        HBox titleBar = new HBox();
        titleBar.setAlignment(Pos.CENTER_RIGHT);
        titleBar.setPrefHeight(30);
        titleBar.setStyle("-fx-background-color: rgba(255, 165, 0, 0.8);"); // Semi-transparent orange

        Button minimizeBtn = new Button("_");
        Button maximizeBtn = new Button("□");
        Button closeBtn = new Button("X");

        minimizeBtn.setOnAction(e -> primaryStage.setIconified(true));
        maximizeBtn.setOnAction(e -> {
            if (primaryStage.isMaximized()) {
                primaryStage.setMaximized(false);
                maximizeBtn.setText("□");
            } else {
                primaryStage.setMaximized(true);
                maximizeBtn.setText("❐");
            }
        });
        closeBtn.setOnAction(e -> primaryStage.close());

        for (Button btn : new Button[]{minimizeBtn, maximizeBtn, closeBtn}) {
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: black;");
            btn.setOnMouseEntered(e -> btn.setStyle("-fx-background-color: rgba(0,0,0,0.1); -fx-text-fill: black;"));
            btn.setOnMouseExited(e -> btn.setStyle("-fx-background-color: transparent; -fx-text-fill: black;"));
        }

        titleBar.getChildren().addAll(minimizeBtn, maximizeBtn, closeBtn);

        // Make the window draggable
        /*titleBar.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });*/
        titleBar.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        return titleBar;
    }
}
