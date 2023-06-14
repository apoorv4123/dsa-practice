package ticTacToe_Game;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// parameters to start the game
	public static int BOARD_SIZE = 3;

	public static enum GameStatus {
		Incomplete, XWins, ZWins, Tie
	}

	// 3x3 MATRIX, on each indes a button is presesnt
	private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
	// whenever a button is clicked for the first time, a X is displayed on it
	boolean crossTurn = true;

	public TicTacToe() {
		super.setTitle("TicTacToe");
		super.setSize(800, 800);

		// grid is the type of layout
		GridLayout grid = new GridLayout(BOARD_SIZE, BOARD_SIZE);
		super.setLayout(grid);
		super.setResizable(false);
		Font font = new Font("Comic Sans", 1, 150);
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JButton button = new JButton("");
				buttons[row][col] = button;
				button.setFont(font);
				button.addActionListener(this);
				super.add(button);
			}
		}
		super.setVisible(true); // for the visibility of the frame
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton clickedButton = (JButton) e.getSource();
		makeMove(clickedButton);
		GameStatus gs = this.getGameStatus();
		if (gs == GameStatus.Incomplete) {
			return;
		}
		declareWinner(gs);

		int choice = JOptionPane.showConfirmDialog(this, "do you want to restart the game?");
		if (choice == JOptionPane.YES_OPTION) {
			// set text of all buttons to empty string
			for (int row = 0; row < BOARD_SIZE; row++) {
				for (int col = 0; col < BOARD_SIZE; col++) {
					buttons[row][col].setText("");
				}
			}
			crossTurn = true;
		} else {
			// terminate
			super.dispose();
		}

	}

	private void makeMove(JButton clickedButton) {

		String btntext = clickedButton.getText(); // text on button
		if (btntext.length() > 0) { // Something is already on that button, or the button is already pressed
			JOptionPane.showMessageDialog(this, "Invalid Move");
			// to check whether someone has won the game or not
		} else {
			// check whose turn it is
			if (crossTurn) {
				clickedButton.setText("X");
			} else {
				clickedButton.setText("O");
			}
			crossTurn = !crossTurn;
		}

	}

	private GameStatus getGameStatus() {

		String text1 = "", text2 = "";
		int row = 0, col = 0;

		// text inside rows
		row = 0;
		while (row < BOARD_SIZE) {
			col = 0;
			while (col < BOARD_SIZE - 1) {
				text1 = buttons[row][col].getText();
				text2 = buttons[row][col + 1].getText();
				if (!text1.equals(text2) || text1.length() == 0) {
					break;
				}
				col++;
			}
			if (col == BOARD_SIZE - 1) {
				if (text1.equals("X")) {
					return GameStatus.XWins;
				} else {
					return GameStatus.ZWins;
				}
			}
			row++;
		}

		// text inside columns
		col = 0;
		while (col < BOARD_SIZE) {
			row = 0;
			while (row < BOARD_SIZE - 1) {
				text1 = buttons[row][col].getText();
				text2 = buttons[row + 1][col].getText();
				if (!text1.equals(text2) || text1.length() == 0) {
					break;
				}
				row++;
			}
			if (row == BOARD_SIZE - 1) {
				if (text1.equals("X")) {
					return GameStatus.XWins;
				} else {
					return GameStatus.ZWins;
				}
			}
			col++;
		}

		// text in diagonal 1
		row = 0;
		col = 0;
		while (row < BOARD_SIZE - 1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row + 1][col + 1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
			row++;
			col++;
		}
		if (row == BOARD_SIZE - 1) {
			if (text1.equals("X")) {
				return GameStatus.XWins;
			} else {
				return GameStatus.ZWins;
			}
		}

		// text in diagonal 2

		row = BOARD_SIZE - 1;
		col = 0;
		while (col < BOARD_SIZE - 1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row - 1][col + 1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
			row--;
			col++;
		}
		if (col == BOARD_SIZE - 1) {
			if (text1.equals("X")) {
				return GameStatus.XWins;
			} else {
				return GameStatus.ZWins;
			}
		}

		String txt = "";
		for (row = 0; row < BOARD_SIZE; row++) {
			for (col = 0; col < BOARD_SIZE; col++) {
				txt = buttons[row][col].getText();
				if (txt.length() == 0) {
					return GameStatus.Incomplete;
				}

			}

		}

		return GameStatus.Tie;
	}

	private void declareWinner(GameStatus gs) {

		if (gs == GameStatus.XWins) {
			JOptionPane.showMessageDialog(this, "X Wins");
		} else if (gs == GameStatus.ZWins) {
			JOptionPane.showMessageDialog(this, "Z Wins");
		} else {
			JOptionPane.showMessageDialog(this, "It is a tie");
		}

	}

}