
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpaceShipTest {

  @Test
  public void testMoveUp() {
    SpaceShip ship = new SpaceShip(2, 2);
    ship.move("U", 5, 5);
    assertEquals(1, ship.getPosition().row);
    assertEquals(2, ship.getPosition().col);
  }

  @Test
  public void testMoveDownOutOfBounds() {
    SpaceShip ship = new SpaceShip(4, 2);
    ship.move("D", 5, 5); // Should not move
    assertEquals(4, ship.getPosition().row);
  }

  @Test
  public void testMoveLeft() {
    SpaceShip ship = new SpaceShip(2, 2);
    ship.move("L", 5, 5);
    assertEquals(1, ship.getPosition().col);
  }

  @Test
  public void testInvalidDirection() {
    SpaceShip ship = new SpaceShip(2, 2);
    ship.move("X", 5, 5); // Invalid direction
    assertEquals(2, ship.getPosition().row);
    assertEquals(2, ship.getPosition().col);
  }
}
