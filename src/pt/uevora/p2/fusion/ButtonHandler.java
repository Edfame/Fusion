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

        int clickedButtonX = 0;
        int clickedButtonY = 0;

        JButton button = (JButton) e.getSource();

        //exemple
        //System.out.println(button.getBackground().equals(buttons[3][3].getBackground()));
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfRows; col++) {
                if (buttons[row][col] == button) {
                    clickedButtonX = col;
                    clickedButtonY = row;
                    System.out.println("y: " + (row + 1));
                    System.out.println("x: " + (col + 1));
                }
            }
        }

    }

    private void buttonFidner(int buttonY, int buttonX) {
        int[] cords = {buttonY, buttonX};

        if (toDeleteButtons.contains(cords)) {
            return;
        }

        toDeleteButtons.add(cords);

        try {
            if (buttons[buttonY + 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                buttonFidner(buttonY + 1, buttonX);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No Button found.");
        }
    }
}
