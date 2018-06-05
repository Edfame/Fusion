package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Window extends JFrame {

    private final int X_SIZE = 500;
    private final int Y_SIZE = 500;
    private List<Color> colorsUsed;

    public Window(int numberOfRows, int numberOfColors) {
        setTitle("Welcome!");
        setSize(X_SIZE, Y_SIZE);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(numberOfRows, numberOfRows));

        JButton[][] buttons = new JButton[numberOfRows][numberOfRows];

        for (int index = 0; index < numberOfRows; index++) {
            for (int index2 = 0; index2 < numberOfRows; index2++) {
                buttons[index][index2] = new JButton();
            }
        }

        colorsUsed = new ArrayList<>();

        for (int index = 0; index < numberOfRows; index++) {
            for (int index2 = 0; index2 < numberOfRows; index2++) {
                JButton button = buttons[index][index2];

                Color randomColor = randomColor(numberOfColors);
                colorsUsed.add(randomColor);

                button.setText("Y: " + (index + 1) + " X: " + (index2 + 1));
                button.addActionListener(new ButtonHandler(buttons, numberOfRows));
                button.setPreferredSize(new Dimension(X_SIZE / numberOfRows, Y_SIZE / numberOfRows));
                button.setBackground(randomColor);
                contentPane.add(button);


            }
        }

    }

    public List<Color> getColorsUsed() {
        return colorsUsed;
    }

    public static Color randomColor(int numOfColors) {
        Color color;

        Random random = new Random();

        int num = random.nextInt(numOfColors);

        switch (num) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.ORANGE;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.CYAN;
                break;
            case 5:
                color = Color.DARK_GRAY;
                break;
            case 6:
                color = Color.GRAY;
                break;
            case 7:
                color = Color.LIGHT_GRAY;
                break;
            case 8:
                color = Color.MAGENTA;
                break;
            case 9:
                color = Color.PINK;
                break;
            case 10:
                color = Color.RED;
                break;
            case 11:
                color = Color.WHITE;
                break;
            case 12:
                color = Color.YELLOW;
                break;
            default:
                color = randomColor(numOfColors);
                break;
        }

        return color;
    }

}