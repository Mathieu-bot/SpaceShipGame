import java.util.Scanner;

public class Game {
  private Grid grid;
  private SpaceShip spaceship;
  private int maxMoves;

  public Game(int rows, int cols, int maxMoves) {
    this.grid = new Grid(rows, cols);
    this.spaceship = new SpaceShip(0, 0);
    this.maxMoves = maxMoves;
    grid.placeSpaceShip(spaceship.getPosition());
  }

  public void start() {
    Scanner scanner = new Scanner(System.in);
    int moveCount = 0;

    while (moveCount < maxMoves) {
      grid.printGrid();
      System.out.print("Enter move (U/D/L/R): ");
      String direction = scanner.nextLine().trim().toUpperCase();

      Position oldPos = new Position(spaceship.getPosition().row, spaceship.getPosition().col);
      spaceship.move(direction, grid.getRows(), grid.getCols());
      Position newPos = spaceship.getPosition();

      if (oldPos.row == newPos.row && oldPos.col == newPos.col) {
        System.out.println("Move invalid or out of bounds.");
        continue;
      }

      if (grid.isJunk(newPos)) {
        System.out.println("Junk crushed!");
      }

      grid.updatePosition(oldPos, newPos);
      moveCount++;
      System.out.println("Move count: " + moveCount + "/" + maxMoves);

      if (grid.countJunks() == 0) {
        grid.printGrid();
        System.out.println("Victory! All junks have been crushed!");
        return;
      }
    }

    System.out.println("Game Over! Out of moves.");
  }
}
