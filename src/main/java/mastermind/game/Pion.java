package mastermind.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Pion {

    public static ImageView pionRouge() throws IOException {
        return new ImageView(new Image(Pion.class.getClassLoader().getResource("img/red.png").openStream(), 36, 36, true, false));
    }
}
