import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.ImmutableTypeGrid;
import cellsociety.alternativeModel.StationaryGameModel;
import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.spreadOfFireCells.FireCell;
import cellsociety.alternativeModel.cell.spreadOfFireCells.TreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class coolExample extends Application{

  public static final int SIZE = 15;
  public static final int CELL_SIZE = 25;
  public static final int SCENE_SIZE = SIZE * CELL_SIZE;
  public static final double COMBUSTIBLE = 0.9;
  public static final String TITLE = "Cool Example";
  public static final Map<CellType, Color> COLORS = Map.of(
      CellType.FIRE, Color.RED,
      CellType.TREE, Color.GREEN,
      CellType.LAND, Color.YELLOW
  );
  private StationaryGameModel myModel;
  private Group root;
  private Scene myScene;
  private coolExample() {
    Grid myGrid = new Grid(SIZE,SIZE,new TreeCell(COMBUSTIBLE));
    for (int i = 0; i <= (SIZE-1)/2; i++) {
      for (int j = 0; j <= SIZE; j++) {
        myGrid.putCellAt(i,j,new TreeCell());
      }
    }
    myGrid.putCellAt(0,SIZE,new FireCell(COMBUSTIBLE));
    myGrid.putCellAt(0,0,new FireCell());
    myModel = new StationaryGameModel(myGrid);
  }

  @Override
  public void start(Stage stage) {
    myScene = setupGame();
    stage.setScene(myScene);
    stage.setTitle(TITLE);
    stage.show();
  }

  private Scene setupGame () {
    root = new Group();
    updateGroup();
    myScene = new Scene(root,SCENE_SIZE,SCENE_SIZE);
    myScene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
    return myScene;
  }

  private void handleKeyInput (KeyCode code) {
    // NOTE new Java syntax that some prefer (but watch out for the many special cases!)
    //   https://blog.jetbrains.com/idea/2019/02/java-12-and-intellij-idea/
    switch (code) {
      case ENTER -> step();
    }
  }

  private void step(){
    myModel.step();
  }

  private void updateGroup(){
    ImmutableTypeGrid myGrid = myModel.lookCurrentGrid();
    root.getChildren().clear();
    for (int i = 0; i <= SIZE; i++) {
      for (int j = 0; j <= SIZE; j++) {
        Rectangle cell = new Rectangle(i * CELL_SIZE,j*CELL_SIZE,CELL_SIZE,CELL_SIZE);
        cell.setFill(COLORS.get(myGrid.getTypeTagAt(i,j)));
      }
    }
  }



}
