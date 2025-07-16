
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

  @Test
  public void testCountJunks() {
    Grid grid = new Grid(5, 5);
    int count = grid.countJunks();
    assertTrue(count > 0); // On a mis 3 'J' dans initializeGrid
  }

  @Test
  public void testJunkDetection() {
    Grid grid = new Grid(5, 5);
    Position pos = new Position(1, 1);
    assertTrue(grid.isJunk(pos));
  }

}
