package tictactoe;

/**
 * The Features interface defines the methods that must be implemented in classes that represent
 * features of a Tic Tac Toe game.
 */
public interface Features {
  /**
   * This method takes a String argument and updates the game board with the player's move.
   *
   * @param str the String representing the move to be made by the player
   */
  void getMove(String str);

  /**
   * This method get the current state of the game.
   */
  void getGameState();

  /**
   * This method get the text that should be displayed on the button, which is X or O.
   *
   * @return the String representing the text to be displayed on the button
   */
  String returnsButtonText();
}
