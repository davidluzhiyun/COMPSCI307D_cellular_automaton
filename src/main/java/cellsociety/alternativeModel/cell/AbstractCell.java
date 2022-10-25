package cellsociety.alternativeModel.cell;

public abstract class AbstractCell {
  private CellType type;
  public AbstractCell(){}

  public CellType getType() {
    return type;
  }

  protected void setType(CellType type) {
    this.type = type;
  }
}
