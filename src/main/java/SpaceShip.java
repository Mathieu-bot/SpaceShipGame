public class SpaceShip {
  private Position position;

  public SpaceShip(int row, int col) {
    this.position = new Position(row, col);
  }

  public Position getPosition() {
    return position;
  }

  public void move(String direction, int gridRows, int gridCols) {
    switch (direction.toUpperCase()) {
      case "U":
        if (position.row > 0) position.row--;
        break;
      case "D":
        if (position.row < gridRows - 1) position.row++;
        break;
      case "L":
        if (position.col > 0) position.col--;
        break;
      case "R":
        if (position.col < gridCols - 1) position.col++;
        break;
      default:
    }
  }
}
