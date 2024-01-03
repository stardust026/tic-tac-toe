package tictactoe;

/**
 * The TicTacToeView interface defines the methods that must be implemented in classes that
 * represent the view of a Tic Tac Toe game.
 */
public interface TicTacToeView {
  /**
   * This method takes a Features object and adds it to the view, allowing the view to access the
   * features of the game.
   *
   * @param features the Features object representing the features of the Tic Tac Toe game
   */
  void addFeatures(Features features);

  /**
   * This method updates the display of the Tic Tac Toe game with the specified string.
   *
   * @param s the String representing the updated display of the Tic Tac Toe game
   */
  void setDisplay(String s);

  /**
   * This method disables the button that the player clicks to make their move, indicating that it
   * has already been used.
   */
  void disableButton();
}
