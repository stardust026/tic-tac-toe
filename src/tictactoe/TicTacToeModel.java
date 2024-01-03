package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This is TicTacToe model class.
 */
public class TicTacToeModel implements TicTacToe {
  // add your implementation here
  private Player[][] board;
  private int rounds;

  public TicTacToeModel() {
    this.board = new Player[3][3];
    this.rounds = 0;
  }

  @Override public void move(int r, int c) {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Out of range");
    }
    if (board[r][c] != null) {
      throw new IllegalArgumentException("Occupied");
    }
    if (isGameOver()) {
      throw new IllegalStateException("game is over");
    }
    board[r][c] = getTurn();
    rounds++;
  }

  @Override public Player getTurn() {
    if (rounds % 2 == 0) {
      return Player.X;
    } else {
      return Player.O;
    }
  }

  @Override public boolean isGameOver() {
    if (getWinner() != null) {
      return true;
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == null) {
          return false;
        }
      }
    }
    return true;
  }

  @Override public Player getWinner() {
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != null) {
        return board[i][0];
      }
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != null) {
        return board[0][i];
      }
    }
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != null) {
      return board[0][0];
    }
    if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != null) {
      return board[0][2];
    }
    return null;
  }

  @Override public Player[][] getBoard() {
    Player[][] newBoard = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        newBoard[i][j] = this.board[i][j];
      }
    }
    return newBoard;
  }

  @Override public Player getMarkAt(int r, int c) {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Out of range");
    }
    return board[r][c];
  }

  @Override public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
        row -> " " + Arrays.stream(row).map(p -> p == null ? " " : p.toString())
            .collect(Collectors.joining(" | ")))
        .collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using 
    // the helpful built-in String.join method.
    /*
     List<String> rows = new ArrayList<>();
     for(Player[] row : getBoard()) {
     List<String> rowStrings = new ArrayList<>();
     for(Player p : row) {
     if(p == null) {
     rowStrings.add(" ");
     } else {
     rowStrings.add(p.toString());
     }
     }
     rows.add(" " + String.join(" | ", rowStrings));
     }
     return String.join("\n-----------\n", rows);
     */
  }
}
