package mastermind.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mastermind.game.Pion;

import java.io.InputStream;

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



        //VBox in center
        VBox vBox = new VBox();
        root.setCenter(vBox);

        vBox.getChildren().add(Pion.pionRouge());


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
