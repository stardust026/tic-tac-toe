import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import tictactoe.Features;
import tictactoe.Player;
import tictactoe.SwingTicTacToeController;
import tictactoe.SwingTicTacToeView;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeModel;
import tictactoe.TicTacToeView;

/**
 * The testController class represents a JUnit test class for the SwingTicTacToeController class. It
 * tests the methods of the Features interface implemented by the controller.
 */
public class TestController {
  private TicTacToe model;
  private Features features;

  /**
   * Sets up the test fixture before each test method is run.
   */
  @Before public void setUp() {
    model = new TicTacToeModel();
    TicTacToeView view = new SwingTicTacToeView("Tic-Tac-Toe");
    features = new SwingTicTacToeController(view, model);
  }

  /**
   * Tests the getMove() method of the Features interface implemented by the controller. It ensures
   * that the correct player mark is set on the model when a move is made.
   */
  @Test public void testGetMove() {
    features.getMove("1 1");
    assertEquals(Player.X, model.getMarkAt(1, 1));
    features.getMove("2 2");
    assertEquals(Player.O, model.getMarkAt(2, 2));
  }

  /**
   * Tests the returnButtonText() method of the Features interface implemented by the controller. It
   * ensures that the button text returned by the method corresponds to the current player turn.
   */
  @Test public void testReturnButtonText() {
    assertEquals("X", features.returnsButtonText());
    features.getMove("1 1");
    assertEquals("O", features.returnsButtonText());
  }
}
