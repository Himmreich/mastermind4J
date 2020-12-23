package mastermind.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MasterMindUIStarter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mastermind4J");
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("Game");
        MenuItem newGameItem = new MenuItem("New");
        MenuItem quitGameItem = new MenuItem("Quit");
        quitGameItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        fileMenu.getItems().addAll(newGameItem, quitGameItem);
        menu.getMenus().add(fileMenu);

        BorderPane root = new BorderPane();
        root.setTop(menu);
        Scene scene = new Scene(root, 640, 480);

        //Flow pane
        FlowPane gamePane = new FlowPane();
        


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
