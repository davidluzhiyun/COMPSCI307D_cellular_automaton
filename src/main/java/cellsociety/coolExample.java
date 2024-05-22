package cellsociety;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.ImmutableTypeGrid;
import cellsociety.alternativeModel.StationaryGameModel;
import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.spreadOfFireCells.FireCell;
import cellsociety.alternativeModel.cell.spreadOfFireCells.TreeCell;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class coolExample extends Application {

  public static final int SIZE = 15;
  public static final int CELL_SIZE = 25;
  public static final int SCENE_SIZE = (SIZE + 1) * CELL_SIZE;
  public static final double COMBUSTIBLE = 1;
  public static final double LESS_COMBUSTIBLE = 0.5;
  public static final String TITLE = "Cool Example";
  public static final Map<CellType, Color> COLORS = Map.of(
      CellType.FIRE, Color.RED,
      CellType.TREE, Color.GREEN,
      CellType.LAND, Color.YELLOW
  );
  private StationaryGameModel myModel;
  private Group root;
  private Scene myScene;


  private void buildModel(){
    Grid myGrid = new Grid(SIZE, SIZE, new TreeCell(COMBUSTIBLE));
    for (int i = 0; i <= (SIZE - 1) / 2; i++) {
      for (int j = 0; j <= SIZE; j++) {
        myGrid.putCellAt(i, j, new TreeCell(LESS_COMBUSTIBLE));
      }
    }
    myGrid.putCellAt(SIZE, 0, new FireCell(COMBUSTIBLE));
    myGrid.putCellAt(0, 0, new FireCell(LESS_COMBUSTIBLE));
    myModel = new StationaryGameModel(myGrid);
  }

  @Override
  public void start(Stage stage) {
    myScene = setupGame();
    stage.setScene(myScene);
    stage.setTitle(TITLE);
    stage.show();
//    Timeline animation = new Timeline();
//    animation.setCycleCount(Timeline.INDEFINITE);
//    animation.play();
  }

  private Scene setupGame() {
    root = new Group();
    buildModel();
    updateGroup();
    myScene = new Scene(root, SCENE_SIZE, SCENE_SIZE, Color.WHITE);
    myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
    return myScene;
  }

  private void handleKeyInput(KeyCode code) {
    // NOTE new Java syntax that some prefer (but watch out for the many special cases!)
    //   https://blog.jetbrains.com/idea/2019/02/java-12-and-intellij-idea/
    switch (code) {
      case ENTER -> step();
    }
  }

  private void step() {
    myModel.step();
    updateGroup();
  }

  private void updateGroup() {
    ImmutableTypeGrid myGrid = myModel.lookCurrentGrid();
    root.getChildren().clear();
    for (int i = 0; i <= SIZE; i++) {
      for (int j = 0; j <= SIZE; j++) {
        Rectangle cell = new Rectangle(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        cell.setFill(COLORS.get(myGrid.getTypeTagAt(i, j)));
        cell.setStroke(Color.BLACK);
        root.getChildren().add(cell);
      }
    }
  }
}
