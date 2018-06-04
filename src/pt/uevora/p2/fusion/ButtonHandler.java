package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ButtonHandler implements ActionListener {

    private JButton[][] buttons;
    private int numberOfRows;
    private Map<String, String> toDelete = new HashMap<>();

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
                    //System.out.println("clicked y:" + (row + 1) + " x:" + (col + 1));
                    buttonFinder(row, col);
                }
            }
        }
        //printo dos buttoes que eram iguais
        if (toDelete.keySet().size() >= 3) {
            for (String cord : toDelete.keySet()) {
                //System.out.println(cord);
            }
        }
        //conversor de string para inteiro das coordenadas
        if (toDelete.keySet().size() >= 3) {
            for (String cord : toDelete.keySet()) {
                int yCord=Integer.parseInt(cord.substring(0,cord.indexOf(" ")));
                int xCord=Integer.parseInt(cord.substring(cord.indexOf(" ")+1,cord.length()));
                //System.out.println(yCord);
                //System.out.println(xCord);
                buttons[yCord][xCord].setBackground(null);
            }
        }

    }

    private void buttonFinder(int buttonY, int buttonX) {
        String cords = "" + buttonY + " " + buttonX;
        if (toDelete.containsKey(cords)) {
            return;
        }
        toDelete.put(cords, buttons[buttonY][buttonX].getText());
        if (buttonY + 1 <= numberOfRows - 1) {
            if (buttons[buttonY + 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {

                buttonFinder(buttonY + 1, buttonX);

            }
        }

        if (buttonY - 1 >= 0) {
            if (buttons[buttonY - 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {

                buttonFinder(buttonY - 1, buttonX);

            }
        }

        if (buttonX + 1 <= numberOfRows - 1) {
            if (buttons[buttonY][buttonX + 1].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {

                buttonFinder(buttonY, buttonX + 1);

            }
        }

        if (buttonX - 1 >= 0) {
            if (buttons[buttonY][buttonX - 1].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {

                buttonFinder(buttonY, buttonX - 1);

            }
        }
    }
}
