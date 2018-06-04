package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ButtonHandler implements ActionListener {

    private JButton[][] buttons;
    private int numberOfRows;
    private List<int[]> toDeleteButtons = new ArrayList<>();

    public ButtonHandler(JButton[][] buttons, int numberOfRows) {
        this.buttons = buttons;
        this.numberOfRows = numberOfRows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        //exemple
        //System.out.println(button.getBackground().equals(buttons[3][3].getBackground()));
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfRows; col++) {
                if (buttons[row][col] == button) {
                    System.out.println("clicked y:" + (row + 1) + " x:" + (col + 1));
                    buttonFinder(row, col);
                }
            }
        }

    }

    private void buttonFinder(int buttonY, int buttonX) {

        int[] cords = {buttonY, buttonX};

        if (buttonY + 1 <= numberOfRows - 1) {
            if (buttons[buttonY + 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                if (!(toDeleteButtons.contains(cords))) {
                    toDeleteButtons.add(cords);
                    System.out.println("added y:" + (buttonY + 1) + " x:" + (buttonX + 1));
                    buttonFinder(buttonY + 1, buttonX);
                }
            }
        }

        if (buttonY - 1 >= 0) {
            if (buttons[buttonY - 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                if (!(toDeleteButtons.contains(cords))) {
                    toDeleteButtons.add(cords);
                    System.out.println("added y:" + (buttonY + 1) + " x:" + (buttonX + 1));
                    buttonFinder(buttonY - 1, buttonX);
                }
            }
        }

        if (buttonX + 1 <= numberOfRows - 1) {
            if (buttons[buttonY][buttonX + 1].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                if (!(toDeleteButtons.contains(cords))) {
                    toDeleteButtons.add(cords);
                    System.out.println("added y:" + (buttonY + 1) + " x:" + (buttonX + 1));
                    buttonFinder(buttonY, buttonX + 1);
                }
            }
        }

        if (buttonX - 1 >= 0) {
            if (buttons[buttonY][buttonX - 1].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                if (!(toDeleteButtons.contains(cords))) {
                    toDeleteButtons.add(cords);
                    System.out.println("added y:" + (buttonY + 1) + " x:" + (buttonX + 1));
                    buttonFinder(buttonY, buttonX - 1);
                }
            }
        }

        return;

    }
}
