package tictactoe;

import java.util.Scanner;

/**
 * The SwingTicTacToeController class represents the controller of a Tic Tac Toe game using Swing.
 * It implements the TicTacToeController and Features interfaces.
 */
public class SwingTicTacToeController implements TicTacToeController, Features {
  private final TicTacToe model;
  private final TicTacToeView view;

  /**
   * Constructs a SwingTicTacToeController object with the specified view and model.
   * @param view the TicTacToeView object representing the view of the game
   * @param model the TicTacToe object representing the model of the game
   */
  public SwingTicTacToeController(TicTacToeView view, TicTacToe model) {
    this.model = model;
    this.view = view;
  }

  @Override public void getMove(String str) {
    Scanner scanner = new Scanner(str);
    int num1 = scanner.nextInt();
    int num2 = scanner.nextInt();
    model.move(num1, num2);
  }

  @Override public void getGameState() {
    if (!model.isGameOver()) {
      view.setDisplay("Turn: " + model.getTurn().toString() + "\n");
    } else {
      view.disableButton();
      if (model.getWinner() == null) {
        view.setDisplay("Tie game.\n");
      } else {
        view.setDisplay(model.getWinner().toString() + " wins.\n");
      }
    }

  }

  @Override public String returnsButtonText() {
    return model.getTurn().toString();
  }

  @Override public void playGame() {
    view.addFeatures(this);
  }
}