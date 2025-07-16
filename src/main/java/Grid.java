import lombok.Getter;

import java.util.Random;

@Getter
public class Grid {
  private char[][] grid;
  private int rows;
  private int cols;

  public Grid(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.grid = new char[rows][cols];
    initializeGrid(5);
  }

  public void initializeGrid(int junkCount) {
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        grid[i][j] = '.';

    Random rand = new Random();
    int placed = 0;

    while (placed < junkCount) {
      int r = rand.nextInt(rows);
      int c = rand.nextInt(cols);

      if (grid[r][c] == '.' && !(r == 0 && c == 0)) {
        grid[r][c] = 'J';
        placed++;
      }
    }
  }

  public void updatePosition(Position oldPos, Position newPos) {
    grid[oldPos.row][oldPos.col] = '.';
    grid[newPos.row][newPos.col] = 'S';
  }

  public void placeSpaceShip(Position pos) {
    grid[pos.row][pos.col] = 'S';
  }

  public boolean isJunk(Position pos) {
    return grid[pos.row][pos.col] == 'J';
  }

  public void clearPosition(Position pos) {
    grid[pos.row][pos.col] = '.';
  }

  public int countJunks() {
    int count = 0;
    for (int i = 0; i < rows; i++)
      for (int j = 0; j < cols; j++)
        if (grid[i][j] == 'J') count++;
    return count;
  }

  public void printGrid() {
    for (char[] row : grid) {
      for (char c : row) System.out.print(c + " ");
      System.out.println();
    }
  }
}
