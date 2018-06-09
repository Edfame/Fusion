package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ButtonHandler implements ActionListener {

    private JButton[][] buttons;
    private int numberOfRows;
    private Map<String, String> toDelete = new HashMap<>();

    public ButtonHandler(JButton[][] buttons, int numberOfRows) {
        this.buttons = buttons;
        this.numberOfRows = numberOfRows;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JButton button = (JButton) event.getSource();

        //exemple
        //System.out.println(button.getBackground().equals(buttons[3][3].getBackground()));
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfRows; col++) {
                if (buttons[row][col].equals(button)) {
                    //System.out.println("clicked y:" + (row + 1) + " x:" + (col + 1));
                    buttonFinder(row, col);
                }
            }
        }

        //conversor de string para inteiro das coordenadas
        if (toDelete.keySet().size() >= 3) {
            for (String cord : toDelete.keySet()) {
                int yCord = Integer.parseInt(cord.substring(0, cord.indexOf(" ")));
                int xCord = Integer.parseInt(cord.substring(cord.indexOf(" ") + 1, cord.length()));
                //System.out.println("Button: " + (yCord + 1) + " " + (xCord + 1));
                buttons[yCord][xCord].setBackground(null);

                while (yCord >= 0) {
                    /*try {
                        TimeUnit.MICROSECONDS.sleep(7500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    if (yCord == 0) {
                        buttons[yCord][xCord].setBackground(Window.randomColor(InicialWindow.win.getNumberOfColrs()));
                        //System.out.println(InicialWindow.win.getColorsUsed().get(new Random().nextInt(InicialWindow.win.getColorsUsed().size())).toString());
                        break;
                    }
                    if (!buttons[yCord][xCord].getBackground().equals(buttons[yCord - 1][xCord].getBackground())) {
                        buttons[yCord][xCord].setBackground(buttons[yCord - 1][xCord].getBackground());
                        buttons[yCord - 1][xCord].setBackground(null);
                    }
                    yCord--;
                }
            }
            InicialWindow.win.setScore(toDelete.size()*toDelete.size());
            toDelete.clear();
        }
    }

    private void buttonFinder(int buttonY, int buttonX) {

        String cords = buttonY + " " + buttonX;

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
