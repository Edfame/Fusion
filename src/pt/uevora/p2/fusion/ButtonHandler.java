package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

    private JButton[][] buttons;
    private int numberOfRows;

    public ButtonHandler(JButton[][] buttons, int numberOfRows){
        this.buttons = buttons;
        this.numberOfRows = numberOfRows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        System.out.println(button.getBackground().equals(buttons[3][3].getBackground()));
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfRows; col++) {
                if (buttons[row][col] == e.getSource()) {
                    System.out.println("y: " + (row + 1));
                    System.out.println("x: " + (col + 1));
                }
            }
        }

    }
}
