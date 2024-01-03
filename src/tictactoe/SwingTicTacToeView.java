package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * The SwingTicTacToeView class represents the graphical user interface of a Tic Tac Toe game using
 * Swing.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView {
  private final JLabel display;
  private final JButton[][] board;

  /**
   * Constructs a SwingTicTacToeView object with the specified caption and initializes the user
   * interface components.
   *
   * @param caption the String representing the caption of the JFrame
   */
  public SwingTicTacToeView(String caption) {
    super(caption);

    setSize(400, 400);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    display = new JLabel("Turn: X");
    display.setFont(new Font("Arial", Font.PLAIN, 40));
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.setBorder(new EmptyBorder(20, 50, 50, 50));
    JPanel gamePanel = new JPanel(new GridLayout(3, 3));
    gamePanel.setPreferredSize(new Dimension(300, 300));
    board = new JButton[3][3];

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = new JButton();
        int top = 0;
        int left = 0;
        int bottom = 0;
        int right = 0;
        if (i == 0) {
          bottom = 2;
        }
        if (j == 0) {
          right = 2;
        }
        if (j == 2) {
          left = 2;
        }
        if (i == 2) {
          top = 2;
        }
        board[i][j].setBorder(
            BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
        board[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
        board[i][j].setActionCommand(String.format("%d %d ", i, j));
        gamePanel.add(board[i][j]);
      }
    }
    mainPanel.add(gamePanel, BorderLayout.CENTER);
    mainPanel.add(display, BorderLayout.NORTH);
    add(mainPanel);
    this.pack();
    this.setVisible(true);
  }

  @Override public void addFeatures(Features features) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j].addActionListener(e -> {
          JButton button = (JButton) e.getSource();
          button.setText(features.returnsButtonText());
          button.setEnabled(false);
          features.getMove(button.getActionCommand());
          features.getGameState();
        });
      }
    }
  }

  @Override public void setDisplay(String s) {
    display.setText(s);
  }

  @Override public void disableButton() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j].setEnabled(false);
      }
    }
  }

}
