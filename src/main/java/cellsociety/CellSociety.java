package cellsociety;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.security.Key;

public class CellSociety {
    private Timeline animation;
    private final double FRAMERATE = 60.0;  // note, this may be the value the user's "speed" modifies...
    public CellSociety(){
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.seconds(1.0/ FRAMERATE), e -> step()));

        animation.play();
    }

    private void step(){
        // anything that needs to be updated periodically goes here...
    }

}
