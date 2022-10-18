package cellsociety;
public record Cell(int xCoordinate, int yCoordinate) {
  public static final int DEAD = 0;
  public static final int ALIVE = 1;
}
